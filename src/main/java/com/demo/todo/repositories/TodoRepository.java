package com.demo.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.todo.entities.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
