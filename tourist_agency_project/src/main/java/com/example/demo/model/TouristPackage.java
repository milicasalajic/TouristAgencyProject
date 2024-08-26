package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "tourist_package")
public class TouristPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String packageName;

    @Lob//longer text
    @Column
    private String packageDescription;

    @Column(nullable = false)
    private Integer time;

    @Column
    private Date dateOffDeparture;

    @Column
    private Date returnDate;

    @Column(nullable = false)
    private Double packagePrice;

    @Column(nullable = false)
    private Integer capacity;

    @ElementCollection
    @CollectionTable(name = "picturesOfTheDestination", joinColumns = @JoinColumn(name = "package_id"))
    @Column(name = "destination_picture")
    private Set<String> picturesOfTheDestination;

    @Lob//longer text
    @Column
    private String schedule;

    @Column(nullable = true)
    private String travelNotes;

    @Column
    private String priceIncludes;

    @Column
    private String priceDoesNotInclude;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Category category;

    @OneToMany(mappedBy = "touristPackage", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private  Set<Trip> trips;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "destination_id", unique = true)
    private Destination destination;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Organizer organizer;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "traveler_tourist_package",
            joinColumns = {
                    @JoinColumn(name = "tourist_package_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "traveler_id", referencedColumnName = "id")
            }
    )
    private Set<Traveler> traveler=new HashSet<>();

    @OneToMany(mappedBy = "touristPackage", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private  Set<Reservation> reservations;



}
