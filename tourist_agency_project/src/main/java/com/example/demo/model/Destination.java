package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String destinationName;

    @Column
    private String destinationDescription;

    @Column
    private String destinationCountry;

    @Column
    private  String hotelName;

    @ElementCollection
    @CollectionTable(name = "hotelPictures", joinColumns = @JoinColumn(name = "destination_id"))
    private Set<String> hotelPictures;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private TouristPackage touristPackage;

}
