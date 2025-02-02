package com.demo.todo.controllers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.demo.todo.entities.Todo;
import com.demo.todo.entities.User;
import com.demo.todo.handlers.ApiError;
import com.demo.todo.handlers.ResponseHandler;
import com.demo.todo.services.TodoService;
import com.demo.todo.services.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class TodoController {

    TodoService service;
    UserService userService;

    TodoController(TodoService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @PutMapping("/todos")
    public ResponseEntity<?> createTodo(@RequestBody @Valid Todo body, @RequestHeader Map<String, String> headers) {

        Long userId = Long.parseLong(headers.get("user_id"));
        User user = userService.findById(userId);

        if (user == null) {
            throw new ApiError(HttpStatus.NOT_FOUND, "No user found");
        }

        Todo todo = new Todo();

        todo.setUser(user);
        todo.setText(body.getText());

        Todo saveTodo = service.create(todo);

        return ResponseHandler.successWithData("Todo created successfully", saveTodo);
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Todo saveTodo = service.findById(id);

        if (saveTodo == null) {
            throw new ApiError(HttpStatus.NOT_FOUND, "No todo is associated with the given id");
        }

        return ResponseHandler.successWithData("Todo fetch successfully", saveTodo);
    }

    @PostMapping("/todos/{id}/complete")
    public ResponseEntity<?> complete(@PathVariable Long id) {

        Todo todo = service.complete(id);

        if (todo == null) {
            throw new ApiError(HttpStatus.NOT_FOUND, "No todo is associated with the given id");
        }

        return ResponseHandler.successWithData("Todo completed successfully", todo);
    }

    @PostMapping("/todos/{id}/un-complete")
    public ResponseEntity<?> unComplete(@PathVariable Long id) {
        Todo todo = service.unComplete(id);

        if (todo == null) {
            throw new ApiError(HttpStatus.NOT_FOUND, "No todo is associated with the given id");
        }

        return ResponseHandler.successWithData("Todo un-completed successfully", todo);
    }

    @GetMapping("/todos")
    public ResponseEntity<?> findAll(@RequestHeader Map<String, String> headers) {

        Long userId = Long.parseLong(headers.get("user_id"));

        return ResponseHandler.successWithData("Todos fetched successfully", service.fetchAll(userId));
    }

}
