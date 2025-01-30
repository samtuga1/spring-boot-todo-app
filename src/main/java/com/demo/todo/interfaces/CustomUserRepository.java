package com.demo.todo.interfaces;

import com.demo.todo.entities.User;

public interface CustomUserRepository {
    User updateName(String name, Long userId);
}
