package com.oteller.reservationservice.kafka;

import com.oteller.reservationservice.dto.ReservationCreatedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReservationEventProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public ReservationEventProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendReservationCreatedEvent(ReservationCreatedEvent event) {
        kafkaTemplate.send("reservation-created", event);
    }
}