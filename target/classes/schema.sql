CREATE TABLE customer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    birthdate TIMESTAMP,
    phoneNumber VARCHAR(20),
    address VARCHAR(255)
);

 CREATE TABLE time_slot (


    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    dateTime TIMESTAMP ,
    delivery_method VARCHAR(20) ,
    free boolean
);