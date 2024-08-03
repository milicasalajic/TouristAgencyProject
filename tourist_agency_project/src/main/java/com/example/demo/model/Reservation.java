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

    @Column
    private ReservationStatus reservationStatus;

    @Column
    private Double reservationPrice;

    @Column(nullable = false)
    private String passengerName;

    @Column(nullable = false)
    private String passengerSurname;

    @Column(nullable = false)
    private String passengerEmail;

    @Column(nullable = false)
    private String passengerNumber;

    @Column(nullable = false)
    private String passengerJMBG;

    @Column(nullable = false)
    private String placeOfResidence;

    @Column(nullable = false)
    private String placeOfEntryIntoTheBus;

    @ElementCollection
    @CollectionTable(name = "other_emails", joinColumns = @JoinColumn(name = "reservation_id"))
    private Set<String> otherEmails;

    private Payment payment;

    //DODATI KORISNIKU REERVACIJU
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User user;

    //jedan turisticki paket ima vise rezervacija
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private TouristPackage touristPackage;



}
