package com.oteller.hotel.controller;

import com.oteller.hotel.model.Hotel;
import com.oteller.hotel.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    public ResponseEntity<Hotel> create(@RequestBody Hotel hotel) {
        return ResponseEntity.ok(hotelService.createHotel(hotel));
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAll() {
        List<Hotel> hotels = hotelService.getAllHotels();
        return ResponseEntity.ok(hotelService.getAllHotels());
    }
}
