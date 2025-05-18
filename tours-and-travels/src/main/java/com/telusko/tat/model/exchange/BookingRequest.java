package com.telusko.tat.model.exchange;

import com.telusko.tat.model.dto.BookingDto;

public record BookingRequest(Integer tickets, Double ticketPrice) {

    public BookingDto getData() {
        return BookingDto.builder()
                         .tickets(tickets)
                         .ticketPrice(ticketPrice)
                         .build();
    }

}
