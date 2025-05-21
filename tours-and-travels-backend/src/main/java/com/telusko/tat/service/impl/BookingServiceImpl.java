package com.telusko.tat.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.telusko.tat.dao.BookingDao;
import com.telusko.tat.exception.BookingNotFoundException;
import com.telusko.tat.mapper.BookingMapper;
import com.telusko.tat.model.dto.BookingDto;
import com.telusko.tat.model.entity.Booking;
import com.telusko.tat.service.api.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingDao bookingDao;

    @Autowired
    private BookingMapper bookingMapper;

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

    public boolean confirmBooking(String bookingId) {
        // TODO: add proper exception handling
        Booking booking = bookingDao.getBookingById(bookingId)
                                    .orElseThrow(() -> new BookingNotFoundException("Booking with id %s not found".formatted(bookingId)));

        //TODO: call 3rd party payment integration service

        return true;
    }

    @Override
    public BookingDto fetchBooking(String bookingId) {
        Booking booking = bookingDao.getBookingById(bookingId)
                                    .orElseThrow(() -> new BookingNotFoundException("Booking with id %s not found".formatted(bookingId)));

        return bookingMapper.toData(booking);
    }

    @Override
    public List<BookingDto> fetchBooking() {
        List<Booking> bookings = bookingDao.getAllBookings();
        return bookingMapper.toDataList(bookings);
    }

    @Override
    public void deleteBooking(String bookingId) {
        bookingDao.removeBooking(bookingId);
    }
}
