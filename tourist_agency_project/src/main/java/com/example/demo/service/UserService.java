package com.example.demo.service;

import com.example.demo.DTO.RegistrationUserDTO;
import com.example.demo.DTO.UpdateUserDTO;
import com.example.demo.error.UserAlreadyExistsException;
import com.example.demo.error.UserNotFoundException;
import com.example.demo.model.Reservation;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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

    public User registration(RegistrationUserDTO userDTO) {
        User user= new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setLastName(userDTO.getLastName());
        user.setUsername(userDTO.getUsername());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setDateOfBirth(userDTO.getDateOfBirth());
        user.setRole(Role.valueOf("TRAVELER"));
        user.setUserPhoto("");
        Set<Reservation> reservations = new HashSet<>();
        user.setReservations(reservations);

        user=userRepository.save(user);
        return user;
    }

    public boolean usernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    public void updateUser(User user, UpdateUserDTO updatedUser) throws UserAlreadyExistsException {

        Optional<User> existingUser = userRepository.findByUsername(updatedUser.getUsername());

        if (existingUser.isPresent() && !existingUser.get().getId().equals(user.getId())) {
            throw new UserAlreadyExistsException("Username already exists."); // Prilagodi izuzetak
        }

        user.setUsername(updatedUser.getUsername());
        user.setName(updatedUser.getName());
        user.setEmail(user.getEmail());
        user.setPassword(updatedUser.getNewPassword());
        user.setDateOfBirth(updatedUser.getDateOfBirth());
        user.setPhoneNumber(updatedUser.getPhoneNumber());
        user.setLastName(updatedUser.getLastName());
        user.setUserPhoto(user.getUserPhoto());

        userRepository.save(user);
    }

}
