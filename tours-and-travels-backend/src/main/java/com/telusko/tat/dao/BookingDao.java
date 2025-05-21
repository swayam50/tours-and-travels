package com.telusko.tat.dao;

import java.util.List;
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
        return bookingRepository.findById(UUID.fromString(id));
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public void removeBooking(String id) {
        bookingRepository.deleteById(UUID.fromString(id));
    }
}
