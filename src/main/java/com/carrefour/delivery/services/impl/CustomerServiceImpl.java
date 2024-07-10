package com.carrefour.delivery.services.impl;

import com.carrefour.delivery.models.entities.Customer;
import com.carrefour.delivery.repositories.CustomerRepository;
import com.carrefour.delivery.services.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public Customer getCustomer(Long customerId) {
        return customerRepository.findById(customerId).orElse( null);
    }
}
