package com.example.demo.service;

import com.example.demo.DTO.AllPackagesDTO;
import com.example.demo.DTO.CategoryDTO;
import com.example.demo.model.Category;
import com.example.demo.model.TouristPackage;
import com.example.demo.repository.TouristPackageRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TouristPackageService {

    @Autowired
    private TouristPackageRepository touristPackageRepository;

    public List<AllPackagesDTO> findAllPackages() {

        List<TouristPackage> packages= touristPackageRepository.findAll();
        List<AllPackagesDTO> packagesDTO=new ArrayList<>();

        for(TouristPackage touristPackage: packages){
            AllPackagesDTO packageDTO= new AllPackagesDTO();
            packageDTO.setPackageName(touristPackage.getPackageName());
            packageDTO.setPackageDescription(touristPackage.getPackageDescription());
            packageDTO.setPackagePrice(touristPackage.getPackagePrice());
            packageDTO.setId(touristPackage.getId());
            Category category = touristPackage.getCategory();
            if (category != null) {
                CategoryDTO categoryDTO = new CategoryDTO();
                categoryDTO.setCategoryName(category.getCategoryName());
                packageDTO.setCategory(categoryDTO);
            }
            packageDTO.setTime(touristPackage.getTime());
            packageDTO.setDateOffDeparture(touristPackage.getDateOffDeparture());
            packageDTO.setReturnDate(touristPackage.getReturnDate());
            packagesDTO.add(packageDTO);
        }
        return packagesDTO;
    }

}
