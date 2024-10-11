package com.example.demo.controller;

import com.example.demo.DTO.LoginUserDTO;
import com.example.demo.DTO.RegistrationUserDTO;
import com.example.demo.DTO.UpdateUserDTO;
import com.example.demo.error.EmailAlreadyExistsException;
import com.example.demo.error.PasswordMismatchException;
import com.example.demo.error.UserAlreadyExistsException;
import com.example.demo.error.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/registration", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> Registration(@Valid @RequestBody RegistrationUserDTO user) throws UserAlreadyExistsException, EmailAlreadyExistsException, PasswordMismatchException {//valid proverava da li su ispunjeni zahtevi unutar registracija korstnika dTO

        if(!user.getPassword().equals(user.getRepeatedPassword())){
            throw new PasswordMismatchException("Passwords do not match.");
        }
        if (userService.usernameExists(user.getUsername())) {
            throw new UserAlreadyExistsException("Username '" + user.getUsername() + "' already exists.");
        }

        // Provera da li mejl već postoji
        if (userService.emailExists(user.getEmail())) {
            throw new EmailAlreadyExistsException("Email '" + user.getEmail() + "' is already registered.");
        }


        User registrationedUser = userService.registration(user);
        return new ResponseEntity<>(registrationedUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> Login(@RequestBody LoginUserDTO loginUserDTO, HttpSession session){

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
    @PostMapping("/logout")
    public ResponseEntity Logout(HttpSession session){

        User loggedUseer = (User) session.getAttribute("user");

        if (loggedUseer == null){
            throw new UserNotFoundException("An error occurred while logging out.");
        }

        session.invalidate();
        return new ResponseEntity("Logout successful.", HttpStatus.OK);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<?> updateUser( @RequestBody UpdateUserDTO updatedUser, HttpSession session) throws PasswordMismatchException, UserNotFoundException, UserAlreadyExistsException {

        User user = (User) session.getAttribute("user");

        if(user == null){
            throw new UserNotFoundException("Only logged users can update profile.");
        }
        if(!updatedUser.getPassword().equals(user.getPassword())){
            throw new PasswordMismatchException("Incorect password.");
        }
        //find if updatet username exsist

        userService.updateUser(user,updatedUser );
        return ResponseEntity.ok("Update succesful");
    }
}
