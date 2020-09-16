package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.Status;
import ru.job4j.accident.repository.AccidentRepository;
import ru.job4j.accident.repository.StatusRepository;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AccidentControl {
    private final AccidentRepository accidentRepository;
    private final StatusRepository statusRepository;


    public AccidentControl(AccidentRepository accidentRepository, StatusRepository statusRepository) {
        this.accidentRepository = accidentRepository;
        this.statusRepository = statusRepository;
    }

    @GetMapping("/create")
    public String create(Model model) {
        statusRepository.findAll().forEach(System.out::println);
        model.addAttribute("statuses", statusRepository.findAll());
        return "accident/create";
    }


    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, HttpServletRequest request) {
        String id = request.getParameter("statusID");
        Status state = statusRepository.findById(Integer.valueOf(id)).get();
        accident.setStatus(state);
        accidentRepository.save(accident);
        return "redirect:/";
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