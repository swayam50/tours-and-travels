package com.telusko.tat.model.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BookingDto {
    private String bookingId;
    private Integer tickets;
    private Double ticketPrice;
    private Double totalPrice;
    private String transactionId;
    private LocalDate bookedAt;
}
