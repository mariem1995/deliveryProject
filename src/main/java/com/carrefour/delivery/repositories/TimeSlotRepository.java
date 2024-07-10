package com.carrefour.delivery.repositories;

import com.carrefour.delivery.models.entities.TimeSlot;
import com.carrefour.delivery.models.enums.DeliveryMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {
    List<TimeSlot> findByDeliveryMethod(DeliveryMethod deliveryMethod);

}
