package com.demo.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.todo.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}