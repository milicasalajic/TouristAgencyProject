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
    private String tripName;

    @Column
    private String tripDescription;

    @Column
    private Double tripPrice;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private TouristPackage touristPackage;

}
