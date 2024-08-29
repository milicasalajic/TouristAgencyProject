package com.example.demo.DTO;

import com.example.demo.model.TouristPackage;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TripDTO {

    private Long id;

    private String tripName;

    private String tripDescription;

    private Double tripPrice;

}
