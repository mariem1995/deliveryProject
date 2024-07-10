package com.carrefour.delivery;

import com.carrefour.delivery.models.entities.Customer;
import com.carrefour.delivery.models.entities.Reservation;
import com.carrefour.delivery.models.entities.TimeSlot;
import com.carrefour.delivery.models.enums.DeliveryMethod;
import com.carrefour.delivery.services.CustomerService;
import com.carrefour.delivery.services.DeliveryService;
import com.carrefour.delivery.services.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarrefourApplication implements CommandLineRunner {
    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    private TimeSlotService timeSlotService;

   @Autowired
   private CustomerService customerService;
    public static void main(String[] args) {
        SpringApplication.run(CarrefourApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        Reservation reservation = new Reservation();
        reservation.setCustomer(customerService.getCustomer(1L));
        DeliveryMethod deliveryMethod = DeliveryMethod.DELIVERY;
        reservation.setDeliveryMethod(deliveryMethod);
        var timeSLots = timeSlotService.getAvailableTimeSLots(deliveryMethod);
        timeSlotService.selectTimeSlot(reservation, timeSLots.get(0));
    }
}
