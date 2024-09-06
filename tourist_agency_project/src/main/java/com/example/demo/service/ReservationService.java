package com.example.demo.service;

import com.example.demo.DTO.ReservationRequestDTO;
import com.example.demo.DTO.ReservationResponseDTO;
import com.example.demo.error.PackageNotFoundException;
import com.example.demo.model.Reservation;
import com.example.demo.model.ReservationStatus;
import com.example.demo.model.TouristPackage;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.repository.TouristPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private TouristPackageRepository touristPackageRepository;

    public ReservationResponseDTO createReservation(ReservationRequestDTO request) {

        Optional<TouristPackage> touristPackageOptional = touristPackageRepository.findByPackageName(request.getPackageName());

        TouristPackage touristPackage = touristPackageOptional.get();

        if(touristPackage==null){
            throw new PackageNotFoundException("Turisticki paket koji zelite da rezervisete ne postoji.");
        }
        Reservation reservation = new Reservation();
        reservation.setNumberOfPeople(request.getNumberOfPeople());
        reservation.setPassengerName(request.getPassengerName());
        reservation.setPassengerLastName(request.getPassengerLastName());
        reservation.setPassengerEmail(request.getPassengerEmail());
        reservation.setPassengerNumber(request.getPassengerNumber());
        reservation.setPassengerJmbg(request.getPassengerJmbg());
        reservation.setPlaceOfResidence(request.getPlaceOfResidence());
        reservation.setPlaceOfEntryIntoTheBus(request.getPlaceOfEntryIntoTheBus());
        reservation.setOtherEmails(request.getOtherEmails());
        reservation.setPayment(request.getPayment());
        reservation.setReservationStatus(ReservationStatus.ON_HOLD);
        reservation.setReservationPrice(touristPackage.getPackagePrice() * request.getNumberOfPeople());
        reservation.setTouristPackage(touristPackage);

        reservation.setDateOfReservation(new Date());
        reservationRepository.save(reservation);

        ReservationResponseDTO response = new ReservationResponseDTO();
        response.setReservationPrice(reservation.getReservationPrice());
        response.setReservationStatus(reservation.getReservationStatus());
        response.setDateOfReservation(reservation.getDateOfReservation());
        response.setPackageName(touristPackage.getPackageName());
        response.setPassengerName(reservation.getPassengerName());
        response.setPassengerLastName(reservation.getPassengerLastName());
        response.setReservationPrice(reservation.getReservationPrice());
        response.setDateOfReservation(reservation.getDateOfReservation());
        response.setPassengerEmail(reservation.getPassengerEmail());
        response.setPassengerNumber(reservation.getPassengerNumber());
        response.setPassengerJmbg(reservation.getPassengerJmbg());
        response.setPlaceOfResidence(reservation.getPlaceOfResidence());
        response.setPlaceOfEntryIntoTheBus(reservation.getPlaceOfEntryIntoTheBus());
        response.setPayment(reservation.getPayment());
        response.setOtherEmails(reservation.getOtherEmails());
        response.setNumberOfPeople(reservation.getNumberOfPeople());

        return response;
    }
}
