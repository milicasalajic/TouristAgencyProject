package com.example.demo.repository;

import com.example.demo.model.TouristPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TouristPackageRepository extends JpaRepository<TouristPackage, Long> {
    List<TouristPackage> findByPackageNameContainingIgnoreCaseAndPackagePriceBetweenAndDateOffDepartureBeforeAndReturnDateAfter(String name, Double minPrice, Double maxPrice, Date date, Date date1);

    List<TouristPackage> findByPackageNameContainingIgnoreCaseAndPackagePriceBetween(String name, Double minPrice, Double maxPrice);

    List<TouristPackage> findByPackageNameContainingIgnoreCaseAndDateOffDepartureBeforeAndReturnDateAfter(String name, Date date, Date date1);

    List<TouristPackage> findByPackagePriceBetweenAndDateOffDepartureBeforeAndReturnDateAfter(Double minPrice, Double maxPrice, Date date, Date date1);

    List<TouristPackage> findByPackageNameContainingIgnoreCase(String name);

    List<TouristPackage> findByPackagePriceBetween(Double minPrice, Double maxPrice);

 //  List<TouristPackage> findByDateOffDepartureBeforeAndReturnDateAfter(Date date, Date date1);
//  List<TouristPackage> findByDateOffDepartureLessThanEqualAndReturnDateGreaterThanEqual(Date dateOffDeparture, Date returnDate);
    @Query("SELECT t FROM TouristPackage t WHERE t.dateOffDeparture <= :date AND t.returnDate >= :date")
    List<TouristPackage> findByDateRange(@Param("date") Date date);

    Optional<TouristPackage> findByPackageName(String packageName);
}
