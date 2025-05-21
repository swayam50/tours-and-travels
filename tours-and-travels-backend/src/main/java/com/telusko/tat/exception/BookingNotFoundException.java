package com.telusko.tat.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class BookingNotFoundException extends BookingException {

    public BookingNotFoundException(String message) {
        super(NOT_FOUND, message);
    }
}
