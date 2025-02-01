package com.demo.todo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.demo.todo.entities.User;
import com.demo.todo.handlers.ResponseHandler;
import com.demo.todo.services.UserService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {

    private UserService userService;

    UserController(UserService service) {
        this.userService = service;
    }

    @PutMapping("/users")
    public ResponseEntity<?> create(@RequestBody @Valid User body) {

        User savedUser = userService.create(body.getName());

        return ResponseHandler.successWithData("User created successfully", savedUser);
    }

}
