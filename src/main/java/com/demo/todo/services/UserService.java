package com.demo.todo.services;

import org.springframework.stereotype.Service;

import com.demo.todo.entities.User;
import com.demo.todo.repositories.UserRepository;

@Service
public class UserService {

    private UserRepository userRepo;

    UserService(UserRepository repository) {
        userRepo = repository;
    }

    User create(String name) {
        return userRepo.save(new User(name));
    }

    User updateName(String name, Long userId) {
        return userRepo.updateName(name, userId);
    }
}
