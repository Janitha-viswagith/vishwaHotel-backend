package com.example.vishwahotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@Getter
@Setter
@AllArgsConstructor

public class Room {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomType;
    private BigDecimal roomPrice;
    private  boolean isBooked = false;
    @Lob
    private Blob photo;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BookedRoom> bookings;

     public  Room(){
         this.bookings = new ArrayList<>();
     }

     public void  addBooking(BookedRoom booking){
         if (bookings == null){
             bookings = new ArrayList<>();
         }

         bookings.add(booking);
         booking.setRoom(this);
         isBooked = true;

         Random random = new Random();

         // Define the length of the random string
         int length = 10;

         // StringBuilder to store the random string
         StringBuilder sb = new StringBuilder();

         // Generate random digits and append them to StringBuilder
         for (int i = 0; i < length; i++) {
             int digit = random.nextInt(10); // Generates a random digit (0-9)
             sb.append(digit);
         }

         // Convert StringBuilder to String
         String bookedCode= sb.toString();
         booking.setBookingConfiramtionCode(bookedCode);

     }
}
