CREATE DATABASE IF NOT EXISTS yatra_prabandhak;

USE yatra_prabandhak;

CREATE TABLE IF NOT EXISTS customers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(15)
);

CREATE TABLE IF NOT EXISTS trips (
    id INT AUTO_INCREMENT PRIMARY KEY,
    destination VARCHAR(100),
    start_date DATE,
    end_date DATE,
    cost DECIMAL(10, 2)
);

CREATE TABLE IF NOT EXISTS bookings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    trip_id INT,
    booking_date DATE,
    FOREIGN KEY (customer_id) REFERENCES customers(id),
    FOREIGN KEY (trip_id) REFERENCES trips(id)
);
