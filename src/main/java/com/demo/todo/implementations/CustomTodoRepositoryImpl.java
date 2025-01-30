package com.demo.todo.implementations;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.todo.entities.Todo;
import com.demo.todo.interfaces.CustomTodoRepository;
import com.demo.todo.repositories.TodoRepository;

public class CustomTodoRepositoryImpl implements CustomTodoRepository {

    @Autowired
    TodoRepository todoRepo;

    @Override
    public Todo markComplete(Long todoId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'markComplete'");
    }

    @Override
    public Todo markUnComplete(Long todoId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'markUnComplete'");
    }

}
