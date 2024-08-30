package com.example.demo.DTO;

import com.example.demo.model.Category;
import com.example.demo.model.TouristPackage;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    private String categoryName;

    private CategoryDTO parentCategory;

    private Set<CategoryDTO> subcategories;

    private Set<AllPackagesDTO> touristPackages;

}
