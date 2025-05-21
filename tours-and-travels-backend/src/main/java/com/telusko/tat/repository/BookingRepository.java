package com.telusko.tat.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.telusko.tat.model.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, UUID> {}
