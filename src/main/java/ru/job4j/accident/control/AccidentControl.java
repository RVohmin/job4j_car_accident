package ru.job4j.accident.control;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.Status;
import ru.job4j.accident.repository.AccidentRepository;
import ru.job4j.accident.repository.StatusRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
public class AccidentControl {
    private final AccidentRepository accidentRepository;
    private final StatusRepository statusRepository;

    @Value("${upload.path}")
    private String uploadPath;


    public AccidentControl(AccidentRepository accidentRepository, StatusRepository statusRepository) {
        this.accidentRepository = accidentRepository;
        this.statusRepository = statusRepository;
    }

    @GetMapping("/create")
    public String create(Model model) {
        statusRepository.findAll().forEach(System.out::println);
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("statuses", statusRepository.findAll());
        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@RequestParam("file") MultipartFile file,
                       @ModelAttribute Accident accident,
                       HttpServletRequest request) throws Exception {
        String id = request.getParameter("statusID");

        if (file != null) {
            String resultFileName = file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFileName));
            accident.setFileName(resultFileName);
        }
        Status state = statusRepository.findById(Integer.valueOf(id)).get();
        accident.setStatus(state);
        accidentRepository.save(accident);
        return "redirect:/";
    }

    @GetMapping("/show")
    public void getFile(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        System.out.println(name);
        resp.setContentType("name=" + name);
        resp.setContentType("image/png");
        resp.setHeader("Content-Disposition",
                "attachment; filename=" + File.pathSeparator + name);
        File file = new File(uploadPath + File.separator + name);
        try (FileInputStream in = new FileInputStream(file)) {
            resp.getOutputStream().write(in.readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        Accident accident = accidentRepository.findById(id).isPresent() ? accidentRepository.findById(id).get() : new Accident();
        model.addAttribute(accident);
        model.addAttribute("statuses", statusRepository.findAll());
        return "accident/edit";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        accidentRepository.delete(accidentRepository.findById(id).get());
        return "redirect:/";
    }
}