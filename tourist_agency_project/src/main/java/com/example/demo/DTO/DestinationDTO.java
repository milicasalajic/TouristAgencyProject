package com.example.demo.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DestinationDTO {

    private Long id;

    private String destinationName;

    private String destinationDescription;

    private String destinationCountry;

    private  String hotelName;

    private Set<String> hotelPictures;
}
