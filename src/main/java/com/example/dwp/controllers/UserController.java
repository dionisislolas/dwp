package com.example.dwp.controllers;

import com.example.dwp.entities.User;
import com.example.dwp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/city/{city}/users")
    public List<User> getUsers(@PathVariable String city) {
        return service.getUsersInOrNear(city);
    }

}
