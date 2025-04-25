package com.oteller.hotel.service;

import com.oteller.hotel.model.Hotel;
import com.oteller.hotel.repository.HotelRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HotelServiceTest {
    @InjectMocks
    private HotelService hotelService;

    @Mock
    private HotelRepository hotelRepository;

    @Test
    public void testCreateHotel() {

        Hotel hotel = new Hotel();
        hotel.setId(1L);
        hotel.setName("Test Hotel");
        hotel.setAddress("Ankara");

        // Arrange
        when(hotelRepository.save(ArgumentMatchers.any(Hotel.class))).thenReturn(hotel);

        // Act
        Hotel savedHotel = hotelService.createHotel(hotel);

        // Assert
        assertNotNull(savedHotel);
        assertEquals(1L, savedHotel.getId());
        assertEquals("Test Hotel", savedHotel.getName());
        assertEquals("Ankara", savedHotel.getAddress());
    }

}