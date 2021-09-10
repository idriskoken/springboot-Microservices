package com.example.sampleproject.controller;

import com.example.sampleproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.sampleproject.services.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userServise;

    @GetMapping()
    public List<User> getAllUsers() {
         return userServise.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userServise.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userServise.deleteUserId(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userServise.updateUser(id,user);
    }
}
