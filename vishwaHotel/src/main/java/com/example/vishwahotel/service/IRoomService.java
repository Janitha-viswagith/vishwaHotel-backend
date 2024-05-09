package com.example.vishwahotel.service;

import com.example.vishwahotel.model.Room;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

public interface IRoomService {

 Room addNewRoom(MultipartFile photo , String roomType , BigDecimal roomPrice) throws SQLException, IOException;
}
