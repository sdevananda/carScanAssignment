package com.example.users.controller;

import com.example.users.Exceptions.UserNotFound;
import com.example.users.entity.User;
import com.example.users.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;
    private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @PostMapping
    public User user(@Valid @RequestBody User user){

        //return "";
        LOGGER.info("Saving user: "+user.getFname());
        return userService.saveUser(user);
    }

    @GetMapping("/all")
    public List<User> fetchUsers(){
        LOGGER.info("Fetching all users");
        return userService.fetchUsers();
    }

    @GetMapping("/{id}")
    public User fetchUserById(@PathVariable("id") Long userId) throws UserNotFound {
        LOGGER.info("Fetching user: "+userId);
        Optional<User> user = userService.fetchUserById(userId);
        if(!user.isPresent()){
            throw new UserNotFound("User doesn't exist");
        }
        return user.get();
    }

    @DeleteMapping("{id}")
    public String deleteUserById(@PathVariable("id") Long userId){
        LOGGER.info("Deleting user: "+userId);
        userService.deleteUserById(userId);
        return  "Deleted User";
    }

    @PutMapping("{id}")
    public User updateUser(@PathVariable("id") Long userId , @RequestBody User user) throws UserNotFound {
        LOGGER.info("Updating user: "+userId);
        return userService.updateUser(userId,user);
    }
}
