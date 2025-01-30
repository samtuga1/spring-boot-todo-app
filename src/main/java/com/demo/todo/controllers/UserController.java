package com.demo.todo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {

    @PutMapping("users/")
    public String create(@RequestBody String entity) {
        // TODO: process PUT request
        return entity;
    }

}
