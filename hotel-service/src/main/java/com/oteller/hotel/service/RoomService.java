package com.oteller.hotel.service;

import com.oteller.hotel.model.Room;
import com.oteller.hotel.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room createRoom(Room room) {
        room.setCreatedAt(LocalDateTime.now());
        room.setUpdatedAt(LocalDateTime.now());
        return roomRepository.save(room);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    public Room updateRoom(Long id, Room updatedRoom) {
        return roomRepository.findById(id).map(room -> {
            room.setHotelId(updatedRoom.getHotelId());
            room.setRoomNumber(updatedRoom.getRoomNumber());
            room.setCapacity(updatedRoom.getCapacity());
            room.setPricePerNight(updatedRoom.getPricePerNight());
            room.setUpdatedAt(LocalDateTime.now());
            return roomRepository.save(room);
        }).orElseThrow(() -> new RuntimeException("Room not found"));
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
