package com.example.vishwahotel.controller;

import com.example.vishwahotel.model.Room;
import com.example.vishwahotel.response.RoomResponse;
import com.example.vishwahotel.service.IRoomService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

@RestController
@RequiredArgsConstructor

@RequestMapping("/rooms")
public class RoomController {

   private final IRoomService roomService;

   @PostMapping("/add/new-room")
   public ResponseEntity <RoomResponse> addNewRoom(
         @RequestParam("photo") MultipartFile photo ,
         @RequestParam("roomType")  String roomType ,
         @RequestParam("roomPrice")  BigDecimal roomPrice) throws SQLException, IOException {

         Room saveRoom = roomService.addNewRoom(photo,roomType,roomPrice);

         RoomResponse response = new RoomResponse(
                 saveRoom.getId(),
                 saveRoom.getRoomType(),
                 saveRoom.getRoomPrice());

           return ResponseEntity.ok(response);
   }
}
