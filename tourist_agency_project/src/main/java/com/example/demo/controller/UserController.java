package com.example.demo.controller;

import com.example.demo.DTO.LoginUserDTO;
import com.example.demo.error.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginUserDTO loginUserDTO, HttpSession session){

        if(loginUserDTO.getUsername().isEmpty() ||loginUserDTO.getPassword().isEmpty()){
            throw new UserNotFoundException("Incorrect data. Please try again.");
        }

        User user =userService.login(loginUserDTO.getUsername(), loginUserDTO.getPassword());

        session.setAttribute("user", user);

        return ResponseEntity.ok().body(Map.of(
                "message", "login successful.",
                "username", user.getUsername(),
                "role", user.getRole()
        ));
    }
}
