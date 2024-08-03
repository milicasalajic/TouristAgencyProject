package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Traveler extends  User{

    @OneToMany(mappedBy = "traveler", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<TouristPackage> reservedPackages;


}
