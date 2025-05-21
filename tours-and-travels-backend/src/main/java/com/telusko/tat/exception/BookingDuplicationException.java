package com.telusko.tat.exception;

import static org.springframework.http.HttpStatus.CONFLICT;

public class BookingDuplicationException extends BookingException {
    public BookingDuplicationException(String message) {
        super(CONFLICT, message);
    }
}
