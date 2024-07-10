package com.carrefour.delivery.services;

import com.carrefour.delivery.models.entities.Customer;

public interface CustomerService {

    Customer getCustomer(Long customerId);
}
