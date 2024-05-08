package com.example.vishwahotel.response;

import com.example.vishwahotel.model.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingResponse {

    private Long bookingId;


    private LocalDate checkInDate;


    private LocalDate checkOutDate;


    private String gustFullName;


    private String gustEmail;


    private int NumOfAdults;


    private int NumofChildren;


    private int totalNumofGuest;


    private  String bookingConfiramtionCode;


    private RoomResponse room;


    public BookingResponse(Long bookingId, LocalDate checkInDate, LocalDate checkOutDate, String bookingConfiramtionCode) {
        this.bookingId = bookingId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.bookingConfiramtionCode = bookingConfiramtionCode;
    }
}
