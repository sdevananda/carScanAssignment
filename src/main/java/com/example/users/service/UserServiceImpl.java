package com.example.users.service;

import com.example.users.entity.User;
import com.example.users.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;
    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> fetchUsers(){
        return userRepo.findAll();
    }

    @Override
    public Optional<User> fetchUserById(Long userId) {
        return userRepo.findById(userId);
    }
}
