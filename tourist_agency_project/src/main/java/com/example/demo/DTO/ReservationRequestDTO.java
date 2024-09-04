package com.example.demo.DTO;

import com.example.demo.model.Payment;
import com.example.demo.model.ReservationStatus;
import com.example.demo.model.TouristPackage;
import com.example.demo.model.User;
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
public class ReservationRequestDTO {

    private Integer numberOfPeople;

    private String passengerName;

    private String passengerLastName;

    private String passengerEmail;

    private String passengerNumber;

    private String passengerJmbg;

    private String placeOfResidence;

    private String placeOfEntryIntoTheBus;

    private Set<String> otherEmails;

    private Payment payment;

    private String packageName;
}
