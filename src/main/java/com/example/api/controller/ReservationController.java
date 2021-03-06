package com.example.api.controller;


import com.example.api.exception.IllegalProcessingException;
import com.example.api.model.Reservation;
import com.example.api.repository.UserRepository;
import com.example.api.service.ReservationService;
import com.example.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.validation.Valid;
import java.net.URI;
import java.security.Principal;

@RestController
@RequestMapping("/reservation")
@CrossOrigin
@IllegalProcessingException
public class ReservationController {

    private final ReservationService reservationService;
    private final UserService userService;

    @Autowired
    public ReservationController(ReservationService reservationService, UserService userService) {
        this.reservationService = reservationService;
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<?> addReservation(@Valid Reservation reservation, Principal principal){
        Reservation savedReservation = reservationService
            .addReservation(reservation, userService.getUserByEmail(principal.getName()));
        return  ResponseEntity.created(URI.create("/reservation/" + savedReservation.getId())).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable Long id, Principal principal){
        reservationService.deleteReservation(id, userService.getUserByEmail(principal.getName()));
        return ResponseEntity.noContent().build();
    }
}
