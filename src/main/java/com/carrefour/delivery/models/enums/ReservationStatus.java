package com.carrefour.delivery.models.enums;

public enum ReservationStatus {
    UNFINISHED("UNFINISHED"),
    IN_TREATEMENT("IN_TREATEMENT"),
    PROCESSED("PROCESSED");

    private final String value;

    ReservationStatus(String valeur) {
        this.value = valeur;
    }

    public String getValue() {
        return this.value;
    }
}
