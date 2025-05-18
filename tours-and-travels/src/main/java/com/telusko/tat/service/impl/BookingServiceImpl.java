package com.telusko.tat.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.telusko.tat.dao.BookingDao;
import com.telusko.tat.model.dto.BookingDto;
import com.telusko.tat.model.entity.Booking;
import com.telusko.tat.service.api.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingDao bookingDao;

    @Override
    public String createBooking(BookingDto bookingData) {
        int noOfTickets = bookingData.getTickets();
        double ticketPrice = bookingData.getTicketPrice();

        double totalPrice = ticketPrice * (double) noOfTickets;

        Booking booking = new Booking();
        booking.setTickets(noOfTickets);
        booking.setTotalPrice(totalPrice);

        return bookingDao.addBooking(booking).getId().toString();
    }

    public boolean confirmBooking(String id) {
        // TODO: add proper exception handling
        Booking booking = bookingDao.getBookingById(id)
                                    .get();

        //TODO: call 3rd party payment integration service

        return true;
    }

    @Override
    public BookingDto fetchBooking(String id) {
        Booking booking = bookingDao.getBookingById(id)
                                    .get();

        return BookingDto.builder()
                         .bookingId(id)
                         .tickets(booking.getTickets())
                         .totalPrice(booking.getTotalPrice())
                         .transactionId(booking.getTransactionId())
                         .bookedAt(booking.getBookedAt())
                         .build();
    }
}
