package com.oteller.reservationservice.controller;

import com.oteller.reservationservice.model.Reservation;
import com.oteller.reservationservice.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        return ResponseEntity.ok(reservationService.createReservation(reservation));
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAll() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getById(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.getReservationById(id));
    }

//    @GetMapping
//    public List<Reservation> getUserReservations(Authentication auth) {
//        String username = auth.getName();
//        return reservationService.findByGuestName(username);
//    }
}
