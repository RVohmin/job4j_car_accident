package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.service.AccidentService;

@Controller // указывает, что класс является контроллером
public class AccidentControl {
    private final AccidentService service;

    public AccidentControl(AccidentService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String create() {
        return "accident/create";
    }


    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident) {
        service.save(accident);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        Accident accident = service.getAccidentById(id);
        model.addAttribute(accident);
        return "accident/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Accident accident) {
        service.update(accident);
        return "redirect:/";
    }
}