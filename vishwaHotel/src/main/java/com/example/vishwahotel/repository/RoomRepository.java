package com.example.vishwahotel.repository;

import com.example.vishwahotel.model.Room;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {
}
