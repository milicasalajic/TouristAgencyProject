package com.example.demo.DTO;

import com.example.demo.model.Reservation;
import com.example.demo.model.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserDTO {

    private String name;

    private String lastName;

    private String username;

    private String email;

    private String phoneNumber;

    private String password;

    private String newPassword;

    private Date dateOfBirth;

    private String userPhoto;

}
