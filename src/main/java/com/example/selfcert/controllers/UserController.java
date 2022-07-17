package com.example.selfcert.controllers;

import com.example.selfcert.models.User;
import com.example.selfcert.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users/{id}")
    public User getUserInformation(@PathVariable(name = "id") Long id) {
        return userService.getUserInformation(id);
    }

}
