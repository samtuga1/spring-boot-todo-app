package com.demo.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.todo.entities.Todo;
import com.demo.todo.interfaces.CustomTodoRepository;

public interface TodoRepository extends JpaRepository<Todo, Long>, CustomTodoRepository {
}
