package com.demo.todo.services;

import org.springframework.stereotype.Service;

import com.demo.todo.entities.Todo;
import com.demo.todo.repositories.TodoRepository;

@Service
public class TodoService {
    TodoRepository todoRepo;

    TodoService(TodoRepository repository) {
        this.todoRepo = repository;
    }

    Todo create(String text) {
        return todoRepo.save(new Todo(text));
    }

    void complete(Long todoId) {
        todoRepo.markComplete(todoId);
    }

    void unComplete(Long todoId) {
        todoRepo.markUnComplete(todoId);
    }
}
