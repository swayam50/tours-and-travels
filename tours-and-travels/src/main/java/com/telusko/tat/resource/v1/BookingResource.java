package com.telusko.tat.resource.v1;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.telusko.tat.model.dto.BookingDto;
import com.telusko.tat.model.exchange.BookingRequest;
import com.telusko.tat.model.exchange.BookingResponse;
import com.telusko.tat.model.exchange.GenericResponse;
import com.telusko.tat.service.api.BookingService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(
    path = "/v1/bookings",
    consumes = APPLICATION_JSON_VALUE,
    produces = APPLICATION_JSON_VALUE
)
public class BookingResource {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody BookingRequest request) {
        String bookingId = bookingService.createBooking(request.getData());

        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{bookingId}")
            .buildAndExpand(bookingId)
            .toUri();

        return ResponseEntity.created(location).body(new GenericResponse("SUCCESS", "Booking with id %s created successfully.".formatted(bookingId)));
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<?> fetchBooking(@PathVariable("bookingId") String id) {
        BookingDto bookingData = bookingService.fetchBooking(id);

        return ResponseEntity.ok().body(new BookingResponse("SUCCESS", "Booking fetched successfully", bookingData));
    }

}
