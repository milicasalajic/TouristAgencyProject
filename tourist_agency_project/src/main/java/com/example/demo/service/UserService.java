package com.example.demo.service;

import com.example.demo.DTO.RegistrationUserDTO;
import com.example.demo.error.UserNotFoundException;
import com.example.demo.model.Reservation;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User login(String username, String password) {

        User user= userRepository.getByUsername(username);
        if(user==null || !user.getPassword().equals(password)){
            throw new UserNotFoundException("Incorrect data. Please try again.");
        }
        return user;
    }

    public User registration(RegistrationUserDTO userDTO) {
        User user= new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setLastName(userDTO.getLastName());
        user.setUsername(userDTO.getUsername());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setDateOfBirth(userDTO.getDateOfBirth());
        user.setRole(Role.valueOf("TRAVELER"));
        user.setUserPhoto("");
        Set<Reservation> reservations = new HashSet<>();
        user.setReservations(reservations);

        user=userRepository.save(user);
        return user;
    }

    public boolean usernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }
   /* public Korisnik registracijaKorisnika(RegistracijaKorisnikaDTO korisnikDTO) throws UserAlreadyExistsException, EmailAlreadyExistsException, PasswordMismatchException {


        Korisnik korisnik=new Korisnik();
        korisnik.setIme(korisnikDTO.getIme());
        korisnik.setPrezime(korisnikDTO.getPrezime());
        korisnik.setKorisnickoIme(korisnikDTO.getKorisnickoIme());
        korisnik.setLozinka(korisnikDTO.getLozinka());
        korisnik.setTelefon(korisnikDTO.getTelefon());
        korisnik.setUloga(korisnikDTO.getUloga());
        korisnik.setMejl(korisnikDTO.getMejl());
        korisnik.setDatumRodjenja(korisnikDTO.getDatumRodjenja());

        korisnik.setBlokiran(false);
        korisnik.setOpisKorisnika("");

        Set<PrijavaProfila> prijava = new HashSet<>();
        korisnik.setPrijava(prijava);
        Set<PrijavaProfila> prijavljen = new HashSet<>();
        korisnik.setPrijavljen(prijavljen);
        Set<Recenzija> recenzije = new HashSet<>();
        korisnik.setRecenzije(recenzije);

        if(this.emailExsist(korisnikDTO.getMejl())) {

            throw new EmailAlreadyExistsException("Korisnik sa ovim email-om već postoji.");
        }

        if(this.userExsist(korisnikDTO.getKorisnickoIme())){

            throw new UserAlreadyExistsException("Korisnik sa ovim korisnickim imenom vec postoji.");
        }
        if (!korisnikDTO.getLozinka().equals(korisnikDTO.getPonovljenaLozinka())) {

            throw new PasswordMismatchException("Lozinke se ne poklapaju.");
        }
        korisnik=korisnikRepository.save(korisnik);


        return korisnik;
    }*/
}
