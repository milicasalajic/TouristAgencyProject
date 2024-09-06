package com.example.demo.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationUserDTO {

    private String name;

    private String lastName;

    private String username;

    private String email;

    private String phoneNumber;

    private String password;

    private String repeatedPassword;

    private Date dateOfBirth;
}
