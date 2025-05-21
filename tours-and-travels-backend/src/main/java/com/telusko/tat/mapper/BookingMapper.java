package com.telusko.tat.mapper;

import java.util.List;
import org.springframework.stereotype.Component;
import com.telusko.tat.model.dto.BookingDto;
import com.telusko.tat.model.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Component
@Mapper(componentModel = "spring")
public interface BookingMapper {

    @Mapping(source = "bookingId", target = "id")
    Booking toEntity(BookingDto bookingDto);

    @Mapping(source = "id", target = "bookingId")
    BookingDto toData(Booking booking);

    List<BookingDto> toDataList(Iterable<Booking> bookings);
}
