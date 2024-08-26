package com.example.demo.controller;


import com.example.demo.DTO.AllPackagesDTO;
import com.example.demo.service.TouristPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/touristpackage")
public class TouristPackageController {

    @Autowired
    private TouristPackageService touristPackageService;


    @GetMapping("/packages")
    public ResponseEntity<List<AllPackagesDTO>> getAllPackages() {

        List<AllPackagesDTO> packagesDTO = touristPackageService.findAllPackages();
        return ResponseEntity.ok(packagesDTO);
    }
    @GetMapping("/search")
    public ResponseEntity<List<AllPackagesDTO>> searchTouristPackages(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            //@RequestParam(required = false) Date packageDate
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date packageDate
    ) {

        List<AllPackagesDTO> packagesDTO = new ArrayList<>();

        if (name != null && minPrice != null && maxPrice != null && packageDate != null) {
            packagesDTO = touristPackageService.findByPackageNameAndPriceRangeAndDate(name, minPrice, maxPrice, packageDate);
        } else if (name != null && minPrice != null && maxPrice != null) {
            packagesDTO = touristPackageService.findByPackageNameAndPriceRange(name, minPrice, maxPrice);
        } else if (name != null && packageDate != null) {
            packagesDTO = touristPackageService.findByPackageNameAndDate(name, packageDate);
        } else if (minPrice != null && maxPrice != null && packageDate != null) {
            packagesDTO = touristPackageService.findByPriceRangeAndDate(minPrice, maxPrice, packageDate);
        } else if (name != null) {
            packagesDTO = touristPackageService.findByPackageName(name);
        } else if (minPrice != null && maxPrice != null) {
            packagesDTO = touristPackageService.findByPriceRange(minPrice, maxPrice);
        } else if (packageDate != null) {
            packagesDTO = touristPackageService.findByDateRange(packageDate);
        } else {
            packagesDTO = touristPackageService.findAll();
        }

        return ResponseEntity.ok(packagesDTO);
    }
}
