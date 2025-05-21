package com.telusko.tat.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import com.telusko.tat.model.vo.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static java.lang.Boolean.FALSE;
import static jakarta.persistence.GenerationType.UUID;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.TemporalType.DATE;
import static jakarta.persistence.TemporalType.TIMESTAMP;
import static com.telusko.tat.model.vo.PaymentStatus.PENDING;

@Entity
@Table(name = "bookings")
@Data @NoArgsConstructor @AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = UUID)
    private UUID id;

    private Integer tickets;

    @Column(name = "total_price")
    private Double totalPrice;

    @Enumerated(STRING)
    private PaymentStatus status;

    @Column(name = "transaction_id", unique = true, length = 64)
    private String transactionId;

    @Column(name = "is_confirmed", nullable = false)
    private Boolean isConfirmed;

    @Temporal(DATE)
    @Column(name = "booked_at")
    private LocalDate bookedAt;

    @Temporal(TIMESTAMP)
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Temporal(TIMESTAMP)
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    @PrePersist
    private void atCreation() {
        this.status = PENDING;
        this.isConfirmed = FALSE;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    private void atUpdation() {
        this.updatedAt = LocalDateTime.now();
    }

}
