package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.repository.AccidentHibernate;

@Controller
public class IndexControl {

//    private final AccidentService service;
//
//    public IndexControl(AccidentService service) {
//        this.service = service;
//    }
//
//    @GetMapping("/")
//    public String index(Model model) {
//        model.addAttribute("map", service.getMem());
//        return "index";
//    }

    private final AccidentHibernate accidents;

    public IndexControl(AccidentHibernate accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("accidents", accidents.getAll());
        return "index";
    }
}