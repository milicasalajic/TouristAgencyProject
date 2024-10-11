package com.example.demo.controller;


import com.example.demo.DTO.AllPackagesDTO;
import com.example.demo.DTO.TouristPackageDTO;
import com.example.demo.error.PackageNotFoundException;
import com.example.demo.error.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.service.TouristPackageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    @GetMapping("/package/{id}")
    public TouristPackageDTO getPackage(@PathVariable Long id)throws PackageNotFoundException {

        TouristPackageDTO foundPackage=touristPackageService.getPackage(id);

        return foundPackage;
    }
   /* @PostMapping("/addNewToursistPackage")
    public ResponseEntity<String> addNewTouristPackage(@RequestBody TouristPackageDTO touristPackageDTO, HttpSession session) throws UserNotFoundException, NoSellerException, CategoryExistsException {

       User user = (User) session.getAttribute("user");
        if (user == null) {
            throw new UserNotFoundException("Please login in.");
        }
        if (!user.getRole().equals(Role.PRODAVAC)) {
            throw new NoSellerException("Samo prodavac može da postavi proizvod na prodaju.");
        }
    }*/
   /* @PostMapping("/addForSale")
    public ResponseEntity<String> SetProductForSell(@RequestBody ProizvodiZaProdajuDTO proizvodDTO, HttpSession session) throws UserNotFoundException, NoSellerException, CategoryExistsException {

        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");
        if (korisnik == null) {
            throw new UserNotFoundException("Morate biti prijavljeni");
        }
        if (!korisnik.getUloga().equals(Uloga.PRODAVAC)) {
            throw new NoSellerException("Samo prodavac može da postavi proizvod na prodaju.");
        }

        Set<Kategorija> kategorijeSet = new HashSet<>();
        for (Kategorija kategorijaDTO : proizvodDTO.getKategorije()) {
            Kategorija kategorija = kategorijaRepository.findByNazivKategorije(kategorijaDTO.getNazivKategorije());
            if (kategorija == null) {
                throw new CategoryExistsException("Kategorija koju želite da unesete ne postoji, morate je dodati.");
            }
            kategorijeSet.add(kategorija);
        }

        proizvodDTO.setKategorije(kategorijeSet); // Postavite set kategorija u DTO pre poziva servisa

        proizvodService.dodajProizvod(proizvodDTO, korisnik);

        return ResponseEntity.ok().body("Proizvod uspešno postavljen na prodaju.");
    }*/

}
