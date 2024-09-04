package com.example.demo.controller;

import com.example.demo.DTO.ReservationRequestDTO;
import com.example.demo.DTO.ReservationResponseDTO;
import com.example.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/bookTouristPackage")
    public ResponseEntity<ReservationResponseDTO> createReservation(@RequestBody ReservationRequestDTO request) {
        System.out.println("ulazi");
        ReservationResponseDTO response = reservationService.createReservation(request);
        System.out.println("pre slanja odgovora");
        return ResponseEntity.ok(response);
    }
}
