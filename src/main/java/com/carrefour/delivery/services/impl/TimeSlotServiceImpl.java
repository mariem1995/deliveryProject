package com.carrefour.delivery.services.impl;

import com.carrefour.delivery.models.entities.Reservation;
import com.carrefour.delivery.models.entities.TimeSlot;
import com.carrefour.delivery.models.enums.DeliveryMethod;
import com.carrefour.delivery.models.enums.ReservationStatus;
import com.carrefour.delivery.repositories.ReservationRepository;
import com.carrefour.delivery.repositories.TimeSlotRepository;
import com.carrefour.delivery.services.TimeSlotService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimeSlotServiceImpl implements TimeSlotService {

    private final TimeSlotRepository timeSlotRepository;
    private final ReservationRepository reservationRepository;

    public TimeSlotServiceImpl(TimeSlotRepository timeSlotRepository, ReservationRepository reservationRepository) {
        this.timeSlotRepository = timeSlotRepository;
        this.reservationRepository = reservationRepository;
    }
    @Override
    public void selectTimeSlot(Reservation reservation, TimeSlot timeSlot) throws IllegalStateException {
        if(!timeSlot.isFree()) throw new IllegalStateException("Booked time slot ");
        else if (!timeSlot.getDeliveryMethod().equals(reservation.getDeliveryMethod())) throw new IllegalStateException("please choose the corresponding timeSlot for this delivery method");
        reservation.setTimeSlot(timeSlot);
        reservation.setReservationStatus(ReservationStatus.IN_TREATEMENT);
        timeSlot.setFree(false);
        reservationRepository.save(reservation);
        timeSlotRepository.save(timeSlot);

    }

    @Override
    public List<TimeSlot> getAvailableTimeSLots(DeliveryMethod deliveryMethod) {
        switch (deliveryMethod) {
            case DELIVERY, DRIVE:
                return timeSlotRepository.findByDeliveryMethod(deliveryMethod).stream().filter(TimeSlot::isFree).toList();
            case DELIVERY_TODAY:
                LocalDate today = LocalDate.now();
                LocalDateTime endOfDay = today.atTime(LocalTime.MAX);
                return timeSlotRepository.findByDeliveryMethod(deliveryMethod).stream()
                        .filter(slot -> slot.getDateTime().isBefore(endOfDay) && slot.isFree())
                        .collect(Collectors.toList());
            case DELIVERY_ASAP:
                 return Collections.singletonList(timeSlotRepository.findByDeliveryMethod(deliveryMethod).stream()
                        .filter(TimeSlot::isFree)
                         .findFirst()
                         .orElse(null));
            default:
                return timeSlotRepository.findAll();
        }
    }
}
