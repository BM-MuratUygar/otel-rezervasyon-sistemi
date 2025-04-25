package com.oteller.notificationservice.consumer;

import com.oteller.notificationservice.dto.ReservationCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ReservationCreatedEventListener {

    @KafkaListener(topics = "reservation-created", groupId = "notification-group", containerFactory = "kafkaListenerContainerFactory")
    public void handleReservationCreated(ReservationCreatedEvent event) {
        System.out.println("🔔 Yeni rezervasyon bildirimi:");
        System.out.printf("Misafir: %s%nOtel ID: %d, Oda ID: %d%nTarih: %s - %s%n",
                event.getGuestName(),
                event.getHotelId(),
                event.getRoomId(),
                event.getCheckInDate(),
                event.getCheckOutDate());
    }
}
