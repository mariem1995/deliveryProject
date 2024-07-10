package com.carrefour.delivery.services;

import com.carrefour.delivery.models.entities.Customer;
import com.carrefour.delivery.models.enums.DeliveryMethod;

import java.util.List;

public interface DeliveryService {
    public void selectDeliveryMethod(Customer customer, DeliveryMethod deliveryMethod);

    public List<DeliveryMethod> getDeliveryMethods();
}
