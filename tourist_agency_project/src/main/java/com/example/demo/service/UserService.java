package com.example.demo.service;

import com.example.demo.error.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User login(String username, String password) {

        User user= userRepository.getByUsername(username);
        if(user==null || !user.getPassword().equals(password)){
            throw new UserNotFoundException("Incorrect data. Please try again.");
        }
        return user;
    }
}
