package com.example.selfcert.controllers;

import com.example.selfcert.models.User;
import com.example.selfcert.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public User getUserInformation(@PathVariable(name = "id") Long id) {
        return userService.getUserInformation(id);
    }

}
