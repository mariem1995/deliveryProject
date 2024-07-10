package com.carrefour.delivery.models.entities;

import com.carrefour.delivery.models.enums.DeliveryMethod;
import com.carrefour.delivery.models.enums.ReservationStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @OneToOne(fetch = FetchType.LAZY)
    private TimeSlot timeSlot;
    @Column(name = "delivery_method", length = 20)
    @Enumerated(EnumType.STRING)
    private DeliveryMethod deliveryMethod;
    @Column(name = "reservation_status", length = 20)
    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;

}
