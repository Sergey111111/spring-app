package ru.job4j.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.springapp.service.CarService;

@Controller
@RequestMapping(value = "cars")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping(value = "/cars")
    public String showCars(ModelMap model) {
        model.addAttribute("cars", carService.findAll());
        return "cars";
    }
}
