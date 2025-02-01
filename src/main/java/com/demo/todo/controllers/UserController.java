package com.demo.todo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.demo.todo.entities.User;
import com.demo.todo.handlers.ApiError;
import com.demo.todo.handlers.ResponseHandler;
import com.demo.todo.services.UserService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PatchMapping("/users/{id}")
    public ResponseEntity<?> updateName(@RequestBody @Valid User body, @PathVariable Long id) {
        if (userService.findById(id) == null) {
            throw new ApiError(HttpStatus.NOT_FOUND, "User not found");
        }
        String name = body.getName();
        User updatedUser = userService.updateName(name, id);

        return ResponseHandler.successWithData("User updated successfully", updatedUser);
    }

}
