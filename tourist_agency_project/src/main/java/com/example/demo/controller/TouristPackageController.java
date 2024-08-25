package com.example.demo.controller;


import com.example.demo.DTO.AllPackagesDTO;
import com.example.demo.service.TouristPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
