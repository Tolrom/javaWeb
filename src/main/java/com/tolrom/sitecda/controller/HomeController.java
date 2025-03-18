package com.tolrom.sitecda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/helloworld")
public class HomeController {

    @GetMapping
    public String home(Model model) {
        model.addAttribute("message", "Hello world");
        return "index";
    }

    @GetMapping("/{firstname}")
    public String firstname(@PathVariable String firstname, Model model) {
        model.addAttribute("firstname", firstname);
        return "helloFirstname";
    }
}
