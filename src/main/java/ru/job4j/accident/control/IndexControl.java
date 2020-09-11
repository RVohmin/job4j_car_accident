package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.repository.AccidentJdbcTemplate;

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

    private final AccidentJdbcTemplate accidents;

    public IndexControl(AccidentJdbcTemplate accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/")
    public String index(Model model) {
//        List<Accident> accidents = this.accidents.getAll();
//        for (Accident item: accidents) {
//            System.out.println(item);
//        }
        model.addAttribute("accidents", accidents.getAll());
        return "index";
    }
}