package com.oteller.reservationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationCreatedEvent {
    private Long reservationId;
    private Long hotelId;
    private Long roomId;
    private String guestName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}