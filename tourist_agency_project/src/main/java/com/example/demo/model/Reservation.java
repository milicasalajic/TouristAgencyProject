package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer numberOfPeople;

    @Column
    private Date dateOfReservation;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;

    @Column(nullable = false)
    private Double reservationPrice;

    @Column(nullable = false)
    private String passengerName;

    @Column(nullable = false)
    private String passengerLastName;

    @Column(nullable = false)
    private String passengerEmail;

    @Column(nullable = false)
    private String passengerNumber;

    @Column(nullable = false)
    private String passengerJmbg;

    @Column(nullable = false)
    private String placeOfResidence;

    @Column(nullable = true)
    private String placeOfEntryIntoTheBus;

    @ElementCollection
    @CollectionTable(name = "other_emails", joinColumns = @JoinColumn(name = "reservation_id"))
    @Column(name = "email")
    private Set<String> otherEmails;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Payment payment;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User userWhoMadeTheReservation;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private TouristPackage touristPackage;
}
