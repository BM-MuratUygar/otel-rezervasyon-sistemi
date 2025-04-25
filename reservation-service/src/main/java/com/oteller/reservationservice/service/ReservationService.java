package com.oteller.reservationservice.service;

import com.oteller.reservationservice.dto.ReservationCreatedEvent;
import com.oteller.reservationservice.kafka.ReservationEventProducer;
import com.oteller.reservationservice.model.Reservation;
import com.oteller.reservationservice.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationEventProducer reservationEventProducer;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, ReservationEventProducer reservationEventProducer) {
        this.reservationRepository = reservationRepository;
        this.reservationEventProducer = reservationEventProducer;
    }

    @Transactional
    public Reservation createReservation(Reservation reservation) {
        boolean conflict = !reservationRepository
                .findByRoomIdAndCheckOutDateAfterAndCheckInDateBefore(
                        reservation.getRoomId(),
                        reservation.getCheckInDate(),
                        reservation.getCheckOutDate()
                ).isEmpty();

        if (conflict) {
            throw new RuntimeException("Room already reserved for this period.");
        }

        reservation.setCreatedAt(LocalDateTime.now());
        Reservation saved = reservationRepository.save(reservation);

        // Event gönder
        ReservationCreatedEvent event = ReservationCreatedEvent.builder()
                .reservationId(saved.getId())
                .hotelId(saved.getHotelId())
                .roomId(saved.getRoomId())
                .guestName(saved.getGuestName())
                .checkInDate(saved.getCheckInDate())
                .checkOutDate(saved.getCheckOutDate())
                .build();

        reservationEventProducer.sendReservationCreatedEvent(event);

        return saved;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
    }
}