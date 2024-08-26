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
import java.util.Date;
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
    public List<AllPackagesDTO> findByPackageNameAndPriceRangeAndDate(String name, Double minPrice, Double maxPrice, Date date) {
        List<TouristPackage> packages = touristPackageRepository.findByPackageNameContainingIgnoreCaseAndPackagePriceBetweenAndDateOffDepartureBeforeAndReturnDateAfter(name, minPrice, maxPrice, date, date);
        return mapToDTO(packages);
    }

    public List<AllPackagesDTO> findByPackageNameAndPriceRange(String name, Double minPrice, Double maxPrice) {
        List<TouristPackage> packages = touristPackageRepository.findByPackageNameContainingIgnoreCaseAndPackagePriceBetween(name, minPrice, maxPrice);
        return mapToDTO(packages);
    }

    public List<AllPackagesDTO> findByPackageNameAndDate(String name, Date date) {
        List<TouristPackage> packages = touristPackageRepository.findByPackageNameContainingIgnoreCaseAndDateOffDepartureBeforeAndReturnDateAfter(name, date, date);
        return mapToDTO(packages);
    }

    public List<AllPackagesDTO> findByPriceRangeAndDate(Double minPrice, Double maxPrice, Date date) {
        List<TouristPackage> packages = touristPackageRepository.findByPackagePriceBetweenAndDateOffDepartureBeforeAndReturnDateAfter(minPrice, maxPrice, date, date);
        return mapToDTO(packages);
    }

    public List<AllPackagesDTO> findByPackageName(String name) {
        List<TouristPackage> packages = touristPackageRepository.findByPackageNameContainingIgnoreCase(name);
        return mapToDTO(packages);
    }

    public List<AllPackagesDTO> findByPriceRange(Double minPrice, Double maxPrice) {
        List<TouristPackage> packages = touristPackageRepository.findByPackagePriceBetween(minPrice, maxPrice);
        return mapToDTO(packages);
    }

    public List<AllPackagesDTO> findByDateRange(Date date) {
        List<TouristPackage> packages = touristPackageRepository.findByDateRange(date);
        return mapToDTO(packages);
    }

    public List<AllPackagesDTO> findAll() {
        List<TouristPackage> packages = touristPackageRepository.findAll();
        return mapToDTO(packages);
    }

    private List<AllPackagesDTO> mapToDTO(List<TouristPackage> packages) {
        List<AllPackagesDTO> packagesDTO = new ArrayList<>();

        for (TouristPackage touristPackage : packages) {
            AllPackagesDTO packageDTO = new AllPackagesDTO();
            packageDTO.setPackageName(touristPackage.getPackageName());
            packageDTO.setPackageDescription(touristPackage.getPackageDescription());
            packageDTO.setPackagePrice(touristPackage.getPackagePrice());
            packageDTO.setId(touristPackage.getId());

            // Mapiranje kategorije u DTO
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
