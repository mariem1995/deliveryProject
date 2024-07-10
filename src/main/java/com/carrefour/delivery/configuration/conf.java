package com.carrefour.delivery.configuration;

import com.carrefour.delivery.repositories.CustomerRepository;
import com.carrefour.delivery.repositories.ReservationRepository;
import com.carrefour.delivery.repositories.TimeSlotRepository;
import com.carrefour.delivery.services.CustomerService;
import com.carrefour.delivery.services.DeliveryService;
import com.carrefour.delivery.services.TimeSlotService;
import com.carrefour.delivery.services.impl.CustomerServiceImpl;
import com.carrefour.delivery.services.impl.DeliveryServiceImpl;
import com.carrefour.delivery.services.impl.TimeSlotServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class conf {
    @Bean
    public TimeSlotService timeSlotService(TimeSlotRepository timeSlotRepository, ReservationRepository reservationRepository){
        return new TimeSlotServiceImpl(timeSlotRepository,reservationRepository);
    }

    @Bean
    public DeliveryService deliveryService(ReservationRepository reservationRepository) {
        return new DeliveryServiceImpl(reservationRepository);
    }

    @Bean
    public CustomerService customerService(CustomerRepository customerRepository) {
        return new CustomerServiceImpl(customerRepository);
    }
}
