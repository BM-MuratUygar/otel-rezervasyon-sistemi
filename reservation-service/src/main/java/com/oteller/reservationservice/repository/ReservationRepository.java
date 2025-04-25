package com.oteller.reservationservice.repository;

import com.oteller.reservationservice.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByRoomIdAndCheckOutDateAfterAndCheckInDateBefore(
            Long roomId, LocalDate checkIn, LocalDate checkOut
    );
}