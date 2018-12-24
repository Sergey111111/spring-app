package ru.job4j.springapp.controller;

import org.springframework.web.bind.annotation.*;
import ru.job4j.springapp.model.User;
import ru.job4j.springapp.service.SecurityService;
import ru.job4j.springapp.service.UserService;
import ru.job4j.springapp.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    SecurityService securityService;

    @Autowired
    UserValidator userValidator;

    @GetMapping(value = "/registration")
    public String Registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping(value = "registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        return "redirect:/welcome";
    }

    @GetMapping(value = "/login")
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

    @GetMapping(value = {"/", "welcome"})
    public String welcome(Model model) {
        return "welcome";
    }

    @GetMapping(value = "/admin")
    public String admin(Model model) {
        return "admin";
    }
}
