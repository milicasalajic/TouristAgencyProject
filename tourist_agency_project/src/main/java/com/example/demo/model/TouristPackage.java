package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class TouristPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String PackageName;

    @Column
    private String PackageDescription;

    @Column(nullable = false)
    private Integer tame;

    @Column
    private Date dateOffDeparture;

    @Column
    private Date returnDate;

    @Column(nullable = false)
    private Double PackagePrice;

    @Column(nullable = false)
    private Integer Capacity;

    @ElementCollection
    @CollectionTable(name = "picturesOfTheDestination", joinColumns = @JoinColumn(name = "package_id"))
    private Set<String> PicturesOfTheDestination;

    @Column
    private String schedule;

    @Column
    private String travelNotes;

    @Column
    private String priceIncludes;

    @Column
    private String priceDoesNotInclude;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Category category;

    @OneToMany(mappedBy = "touristPackage", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private  Set<Trip> trips;

    @OneToOne(mappedBy = "touristPackage", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Destination destination;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Organizer organizer;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Traveler traveler;

    @OneToMany(mappedBy = "touristPackage", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private  Set<Reservation> reservations;



}
