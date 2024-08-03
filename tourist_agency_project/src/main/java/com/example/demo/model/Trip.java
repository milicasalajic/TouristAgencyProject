package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Trip {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String TripName;

    @Column
    private String TripDescription;

    @Column
    private Double TripPrice;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private TouristPackage touristPackage;

}
