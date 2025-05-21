package com.telusko.tat.model.exchange;

import java.util.List;
import com.telusko.tat.model.dto.BookingDto;

public record BookingResponse(String status, String message, Object payload) {
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";

    public static BookingResponse success(String message) {
        return new BookingResponse(SUCCESS, message, null);
    }

    public static BookingResponse error(String message) {
        return new BookingResponse(ERROR, message, null);
    }

    public static BookingResponse success(String message, BookingDto payload) {
        return new BookingResponse(SUCCESS, message, payload);
    }

    public static BookingResponse error(String message, BookingDto payload) {
        return new BookingResponse(ERROR, message, payload);
    }

    public static BookingResponse success(String message, List<BookingDto> payload) {
        return new BookingResponse(SUCCESS, message, payload);
    }

    public static BookingResponse error(String message, List<BookingDto> payload) {
        return new BookingResponse(ERROR, message, payload);
    }
}
