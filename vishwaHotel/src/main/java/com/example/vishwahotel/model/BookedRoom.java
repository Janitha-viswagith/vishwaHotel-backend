package com.example.vishwahotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Lazy;
import org.yaml.snakeyaml.events.Event;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BookedRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @Column(name = "check_In")
    private LocalDate checkInDate;

    @Column(name = "check_out")
    private LocalDate checkOutDate;

    @Column(name = "guest_FullName")
    private String gustFullName;

    @Column(name = "gust_Email")
    private String gustEmail;

    @Column(name = "adults")
    private int NumOfAdults;

    @Column(name = "children")
    private int NumofChildren;

    @Column(name = "total_guest")
    private int totalNumofGuest;

    @Column(name = "comfirmation_Code")
    private  String bookingConfiramtionCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private  Room room;



    public void calculateTotalNumofGuest() {
        this.totalNumofGuest = this.NumofChildren + NumOfAdults;
    }

    public void setNumofChildren(int numofChildren) {
        NumofChildren = numofChildren;
        calculateTotalNumofGuest();
    }

    public void setNumOfAdults(int numOfAdults) {
        NumOfAdults = numOfAdults;
        calculateTotalNumofGuest();
    }

    public void setBookingConfiramtionCode(String bookingConfiramtionCode) {
        this.bookingConfiramtionCode = bookingConfiramtionCode;
    }



}
