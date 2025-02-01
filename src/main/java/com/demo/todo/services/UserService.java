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

    public User create(String name) {
        return userRepo.save(new User(name));
    }

    public User updateName(String name, Long userId) {
        User maybeUser = userRepo.findById(userId).orElse(null);
        if (maybeUser == null)
            return null;
        User user = maybeUser;
        user.setName(name);
        return userRepo.save(user);
    }
}
