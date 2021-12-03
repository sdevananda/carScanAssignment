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
    public User fetchUserById(@PathVariable("id") Long userId){
        return userService.fetchUserById(userId).get();
    }

    @DeleteMapping("{id}")
    public String deleteUserById(@PathVariable("id") Long userId){
        userService.deleteUserById(userId);
        return  "Deleted User";
    }

    @PutMapping("{id}")
    public User updateUser(@PathVariable("id") Long userId , @RequestBody User user){
        return userService.updateUser(userId,user);
    }
}
