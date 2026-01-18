package com.bankingSystem.UIS.controller;


import com.bankingSystem.UIS.entity.User;
import com.bankingSystem.UIS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        System.out.println("Reached Rquest here" + user.getUsername() + " " + user.getEmail() + " " + user.getRole() + " " + user.getPassword());
        userRepository.save(user);
        return "User registered successfully with ID: " + user.getId();
    }

    @GetMapping("/all")
    public List<User> getAllRegisteredUsers() {
        return userRepository.findAll();
    }
}
