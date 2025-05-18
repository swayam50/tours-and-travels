package com.telusko.tat.service.api;

import java.util.List;
import com.telusko.tat.model.dto.BookingDto;

public interface BookingService {

    String createBooking(BookingDto bookingData);

    BookingDto fetchBooking(String id);

}
