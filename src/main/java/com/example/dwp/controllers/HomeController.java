package com.example.dwp.controllers;

import com.example.dwp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserService service;

    @GetMapping
    public String getIndex() {
        return "redirect:/city/London/users";
    }

    @GetMapping("/city/{city}/users")
    public String getIndex(Model model, @PathVariable String city) {
        model.addAttribute("userList", service.getUsersInOrNear(city));
        return "home/index";
    }
}
