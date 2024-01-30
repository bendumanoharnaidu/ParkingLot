package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    @Test
    public void testCar() {
        Car car = new Car("KA-01-HH-1234", "White");

        assertEquals("KA-01-HH-1234", car.getRegistrationNumber());
        assertEquals("White", car.getColor());
    }
    @Test
    public void testCar1() {
        Car car = new Car("KA-01-HH-1234", "White");

        assertEquals("White", car.getColor());
    }

}