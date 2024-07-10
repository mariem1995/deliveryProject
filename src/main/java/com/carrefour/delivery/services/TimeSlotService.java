package com.carrefour.delivery.services;

import com.carrefour.delivery.models.entities.Reservation;
import com.carrefour.delivery.models.entities.TimeSlot;
import com.carrefour.delivery.models.enums.DeliveryMethod;

import java.util.List;

public interface TimeSlotService {

    void selectTimeSlot(Reservation reservation, TimeSlot timeSlot)  throws IllegalStateException;

     List<TimeSlot> getAvailableTimeSLots(DeliveryMethod deliveryMethod);
}
