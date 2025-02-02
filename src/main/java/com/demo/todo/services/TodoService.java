package com.demo.todo.services;

import java.util.Collection;
import org.springframework.stereotype.Service;

import com.demo.todo.entities.Todo;
import com.demo.todo.repositories.TodoRepository;

@Service
public class TodoService {
    TodoRepository todoRepo;

    TodoService(TodoRepository repository) {
        this.todoRepo = repository;
    }

    public Todo create(Todo todo) {
        return todoRepo.save(todo);
    }

    public Todo findById(Long id) {
        return todoRepo.findById(id).orElse(null);
    }

    public Todo complete(Long todoId) {
        Todo todo = todoRepo.findById(todoId).orElse(null);
        if (todo != null) {
            todo.setCompleted(true);
            return todoRepo.save(todo);
        }
        return null;
    }

    public Todo unComplete(Long todoId) {
        Todo todo = todoRepo.findById(todoId).orElse(null);
        if (todo != null) {
            todo.setCompleted(false);
            return todoRepo.save(todo);
        }
        return null;
    }

    public Collection<Todo> fetchAll(Long userId) {
        return todoRepo.findByUserId(userId);
    }
}
