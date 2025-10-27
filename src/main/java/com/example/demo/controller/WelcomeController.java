package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/welcome")
public class WelcomeController {

    @GetMapping(value = "/")
    public String welcome(Model model) {
        // Add attribute name & value to the model
        model.addAttribute("message", "Welcome to the Demo Application!");
        model.addAttribute("author", "Chief Anas");
        model.addAttribute("version", "1.0.0");

        // Return view name (looks for templates/welcome.html)
        return "welcome";
    }
}
    