package com.example.demo.DTO;

import com.example.demo.model.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TouristPackageDTO {

    private Long id;

    private String packageName;

    private String packageDescription;

    private Integer time;

    private Date dateOffDeparture;

    private Date returnDate;

    private Double packagePrice;

    private Set<String> picturesOfTheDestination;

    private String schedule;

    private String travelNotes;

    private String priceIncludes;

    private String priceDoesNotInclude;

    private  Set<TripDTO> trips;

    private DestinationDTO destination;


}
