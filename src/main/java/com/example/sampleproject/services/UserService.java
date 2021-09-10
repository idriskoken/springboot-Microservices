package com.example.sampleproject.services;

import com.example.sampleproject.entity.User;

import java.util.List;

public interface UserService {
   public List<User> getAllUsers();

   public User getUserById(Long id);

   public void deleteUserId(Long id);

   public User updateUser(Long id, User user);
}
