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
public class AllPackagesDTO {

    private Long id;

    private String PackageName;

    private String PackageDescription;

    private Integer time;

    private Date dateOffDeparture;

    private Date returnDate;

    private Double PackagePrice;

    private AllCategoriesDTO category;

}

