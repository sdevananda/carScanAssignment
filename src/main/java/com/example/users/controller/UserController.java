package com.example.users.controller;

import com.example.users.entity.User;
import com.example.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping
    public User user(@RequestBody User user){

        //return "";
        return userService.saveUser(user);
    }

    @GetMapping("/all")
    public List<User> fetchUsers(){
        return userService.fetchUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> fetchUserById(@PathVariable("id") Long userId){
        return userService.fetchUserById(userId);
    }
}
