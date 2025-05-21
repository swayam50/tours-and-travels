package com.telusko.tat.exmap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.telusko.tat.exception.BookingException;
import com.telusko.tat.model.exchange.GenericResponse;

@RestControllerAdvice
public class BookingExceptionHandler {

    @ExceptionHandler(exception = BookingException.class)
    public ResponseEntity<?> handleBookingException(BookingException ex) {
        return new ResponseEntity<>(GenericResponse.error(ex.getMessage()), ex.getStatus());
    }

}
