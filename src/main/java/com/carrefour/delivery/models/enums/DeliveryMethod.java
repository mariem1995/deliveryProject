package com.carrefour.delivery.models.enums;

public enum DeliveryMethod {
    DRIVE("DRIVE"),
    DELIVERY ("DELIVERY"),
    DELIVERY_TODAY("DELIVERY_TODAY"),
    DELIVERY_ASAP("DELIVERY_ASAP");

    private final String value;

    DeliveryMethod(String valeur) {
        this.value = valeur;
    }

    public String getValue() {
        return this.value;
    }


}
