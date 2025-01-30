package com.demo.todo.interfaces;

import com.demo.todo.entities.Todo;

public interface CustomTodoRepository {
    public Todo markComplete(Long todoId);

    public Todo markUnComplete(Long todoId);
}
