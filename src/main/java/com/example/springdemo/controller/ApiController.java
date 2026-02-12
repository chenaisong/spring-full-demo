package com.example.springdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.model.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Operation(summary = "Get specific user object by it's id.")
    @GetMapping("/users/{id}")
    public User user(@Parameter(description = "id of the user.") @PathVariable("id") long id) {
        return new User();
    }

}
