package com.telusko.tat.dao;

import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.telusko.tat.model.entity.Booking;
import com.telusko.tat.repository.BookingRepository;

@Component
public class BookingDao {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking addBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Optional<Booking> getBookingById(String id) {
        //TODO: handle SQL exception
        return bookingRepository.findById(UUID.fromString(id));
    }
}
