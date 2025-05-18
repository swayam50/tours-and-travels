package com.telusko.tat.model.exchange;

import com.telusko.tat.model.dto.BookingDto;

public record BookingResponse(String status, String message, BookingDto payload) {
}
