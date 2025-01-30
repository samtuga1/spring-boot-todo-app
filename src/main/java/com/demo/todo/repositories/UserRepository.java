package com.demo.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.todo.entities.User;
import com.demo.todo.interfaces.CustomUserRepository;

public interface UserRepository extends JpaRepository<User, Long>, CustomUserRepository {
}