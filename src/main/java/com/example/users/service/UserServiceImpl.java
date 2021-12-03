package com.example.users.service;

import com.example.users.entity.User;
import com.example.users.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

    @Override
    public void deleteUserById(Long userId) {
        userRepo.deleteById(userId);
    }

    @Override
    public User updateUser(Long userId, User user) {
        User userFromDb = userRepo.findById(userId).get();

        if(Objects.nonNull(user.getFname()) && !"".equalsIgnoreCase(user.getFname())){
            userFromDb.setFname(user.getFname());
        }
        if(Objects.nonNull(user.getLname()) && !"".equalsIgnoreCase(user.getLname())){
            userFromDb.setLname(user.getLname());
        }
        if(Objects.nonNull(user.getCity()) && !"".equalsIgnoreCase(user.getCity())){
            userFromDb.setCity(user.getCity());
        }
        if(Objects.nonNull(user.getDob()) && !"".equalsIgnoreCase(String.valueOf(user.getDob()))){
            userFromDb.setDob(user.getDob());
        }
        if(Objects.nonNull(user.getMobile()) && !"".equalsIgnoreCase(user.getMobile())){
            userFromDb.setMobile(user.getMobile());
        }

        return userRepo.save(userFromDb);
    }
}
