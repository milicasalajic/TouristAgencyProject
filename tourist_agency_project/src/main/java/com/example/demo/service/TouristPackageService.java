package com.example.demo.service;

import com.example.demo.DTO.*;
import com.example.demo.error.PackageNotFoundException;
import com.example.demo.model.Category;
import com.example.demo.model.Destination;
import com.example.demo.model.TouristPackage;
import com.example.demo.model.Trip;
import com.example.demo.repository.TouristPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
                AllCategoriesDTO categoryDTO = new AllCategoriesDTO();
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

            Category category = touristPackage.getCategory();
            if (category != null) {
                AllCategoriesDTO categoryDTO = new AllCategoriesDTO();
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

    public TouristPackageDTO getPackage(Long id) throws PackageNotFoundException {

        Optional<TouristPackage> foundPackage=touristPackageRepository.findById(id);
        if (!foundPackage.isPresent()) {
            throw new PackageNotFoundException("Package not found.");
        }
        TouristPackage touristPackage=foundPackage.get();
        TouristPackageDTO touristPackageDTO=new TouristPackageDTO();
        touristPackageDTO.setPackageName(touristPackage.getPackageName());
        touristPackageDTO.setPackageDescription(touristPackage.getPackageDescription());
        touristPackageDTO.setPackagePrice(touristPackage.getPackagePrice());
        touristPackageDTO.setId(touristPackage.getId());
        touristPackageDTO.setTime(touristPackage.getTime());
        touristPackageDTO.setDateOffDeparture(touristPackage.getDateOffDeparture());
        touristPackageDTO.setReturnDate(touristPackage.getReturnDate());
        touristPackageDTO.setPicturesOfTheDestination(touristPackage.getPicturesOfTheDestination());
        touristPackageDTO.setDestination(touristPackageDTO.getDestination());
        touristPackageDTO.setPriceDoesNotInclude(touristPackage.getPriceDoesNotInclude());
        touristPackageDTO.setPriceIncludes(touristPackage.getPriceIncludes());
        touristPackageDTO.setSchedule(touristPackage.getSchedule());
        touristPackageDTO.setTravelNotes(touristPackage.getTravelNotes());

        Destination destination=touristPackage.getDestination();
        if(destination!=null){
            DestinationDTO destinationDTO=new DestinationDTO();
            destinationDTO.setDestinationName(destination.getDestinationName());
            destinationDTO.setDestinationCountry(destination.getDestinationCountry());
            destinationDTO.setDestinationDescription(destination.getDestinationDescription());
            destinationDTO.setId(destination.getId());
            destinationDTO.setHotelName(destination.getHotelName());
            destinationDTO.setHotelPictures(destination.getHotelPictures());
            touristPackageDTO.setDestination(destinationDTO);
        }
        Set<TripDTO> tripDTOSet = new HashSet<>();
        for (Trip trip : touristPackage.getTrips()) {
            TripDTO tripDTO = new TripDTO();

            tripDTO.setTripName(trip.getTripName());
            tripDTO.setTripDescription(trip.getTripDescription());
            tripDTO.setId(trip.getId());
            tripDTO.setTripPrice(trip.getTripPrice());

            tripDTOSet.add(tripDTO);
        }
        touristPackageDTO.setTrips(tripDTOSet);
        return touristPackageDTO;
    }
}
