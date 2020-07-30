package com.project.Journal.controller;

import com.project.Journal.models.User;
import com.project.Journal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MainController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{userid}")
    public User getUser(@PathVariable("userid") Long id){
        Optional<User> result = userRepository.findById(id);
        return result.get();
    }

    @PostMapping("/user")
    public User adduser(@RequestBody User user){
        User result = userRepository.save(user);
        return result;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
