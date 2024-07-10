package com.carrefour.delivery.services.impl;


import com.carrefour.delivery.models.entities.*;
import com.carrefour.delivery.models.enums.DeliveryMethod;

import com.carrefour.delivery.models.enums.ReservationStatus;
import com.carrefour.delivery.repositories.ReservationRepository;
import com.carrefour.delivery.services.DeliveryService;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final ReservationRepository reservationRepository;

    public DeliveryServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
    @Override
    public void selectDeliveryMethod(Customer customer, DeliveryMethod deliveryMethod) {
        Reservation reservation = new Reservation();
        reservation.setReservationStatus(ReservationStatus.UNFINISHED);
        reservation.setCustomer(customer);
        reservation.setDeliveryMethod(deliveryMethod);
        reservationRepository.save(reservation);
    }

    @Override
    public List<DeliveryMethod> getDeliveryMethods() {
        return Arrays.stream(DeliveryMethod.values()).toList();
    }

}
