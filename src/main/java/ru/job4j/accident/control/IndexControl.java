package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentRepository;

import java.util.ArrayList;
import java.util.List;

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

//    private final AccidentRepository accidents;
//
//    public IndexControl(AccidentHibernate accidents) {
//        this.accidents = accidents;
//    }

//    @GetMapping("/")
//    public String index(Model model) {
//        model.addAttribute("accidents", accidents.getAll());
//        return "index";
//    }
private final AccidentRepository accidents;

    public IndexControl(AccidentRepository accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Accident> res = new ArrayList<>();
        accidents.findAll().forEach(res::add);
        model.addAttribute("accidents", res);
        return "index";
    }
}