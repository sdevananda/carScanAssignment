package com.example.users.service;

import com.example.users.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    public User saveUser(User user);

    public List<User> fetchUsers();

    public Optional<User> fetchUserById(Long userId);

    public void deleteUserById(Long userId);

    public User updateUser(Long userId, User user);
}
