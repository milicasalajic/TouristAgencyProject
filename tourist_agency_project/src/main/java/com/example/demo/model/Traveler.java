package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Traveler extends  User{

    @ManyToMany(mappedBy = "traveler", fetch = FetchType.LAZY)
    private Set<TouristPackage> touristPackages=new HashSet<>();


}
