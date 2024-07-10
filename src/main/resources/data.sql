
INSERT INTO time_slot (id, dateTime, delivery_method, free) VALUES
(1, '2024-07-10 10:00:00', 'DRIVE', TRUE),
(2, '2024-07-10 10:00:00', 'DELIVERY', TRUE),
(3, '2024-08-10 10:00:00', 'DELIVERY', TRUE),
(4, '2024-07-10 11:00:00', 'DELIVERY_ASAP', TRUE),
(5, '2024-07-10 12:00:00', 'DELIVERY_TODAY', TRUE);

INSERT INTO customer(id,firstname,lastname,birthdate,phoneNumber,address) values
(1,'Jack','Black','2090-07-10 10:00:00', '07 11 11 11 11', '1 rue lafayette')