package com.demo.todo.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.todo.entities.User;
import com.demo.todo.interfaces.CustomUserRepository;
import com.demo.todo.repositories.UserRepository;

public class CustomUserRepositoryImpl implements CustomUserRepository {

    @Autowired
    UserRepository userRepo;

    @Override
    public User updateName(String name, Long userId) {
        Optional<User> maybeUser = userRepo.findById(userId);
        if (!maybeUser.isPresent())
            return null;
        User user = maybeUser.get();
        user.setName(name);
        return userRepo.save(user);
    }

}
