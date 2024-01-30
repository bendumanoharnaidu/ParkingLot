package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingLotTest {
    @Test
    public void testParkingLot() {
        ParkingLot parkingLot = new ParkingLot(6);
        assertEquals(1, parkingLot.parkCar(new Car("KA-01-HH-1234", "White")));
        assertEquals(2, parkingLot.parkCar(new Car("KA-01-HH-9999", "White")));
        assertEquals(3, parkingLot.parkCar(new Car("KA-01-BB-0001", "Black")));
        assertEquals(4, parkingLot.parkCar(new Car("KA-01-HH-7777", "Red")));
        assertEquals(5, parkingLot.parkCar(new Car("KA-01-HH-2701", "Blue")));
        assertEquals(6, parkingLot.parkCar(new Car("KA-01-HH-3141", "Black")));

        assertEquals(-1, parkingLot.parkCar(new Car("KA-01-HH-3141", "Black")));
        assertEquals(-1, parkingLot.parkCar(new Car("KA-01-HH-1234", "White")));


    }
    @Test
    public void CheckIfCarIsParkedOrNot() {
        ParkingLot parkingLot = new ParkingLot(4);
        parkingLot.parkCar(new Car("KA-01-HH-1234", "White"));
        parkingLot.parkCar(new Car("KA-01-HH-9999", "White"));
        parkingLot.parkCar(new Car("KA-01-BB-0001", "Black"));
        parkingLot.parkCar(new Car("KA-01-HH-7777", "Red"));

        assertTrue(parkingLot.isCarParked("KA-01-HH-1234"));
        assertTrue(parkingLot.isCarParked("KA-01-HH-9999"));
        assertEquals(false, parkingLot.isCarParked("KA-01-HH-0000"));

    }
    @Test
    public void getCountOfCarsByColor() {
        ParkingLot parkingLot = new ParkingLot(4);
        parkingLot.parkCar(new Car("KA-01-HH-1234", "White"));
        parkingLot.parkCar(new Car("KA-01-HH-9999", "White"));
        parkingLot.parkCar(new Car("KA-01-BB-0001", "Black"));
        parkingLot.parkCar(new Car("KA-01-HH-7777", "Red"));

        assertEquals(2, parkingLot.getCountCarsByColor("White"));
        assertEquals(1, parkingLot.getCountCarsByColor("Black"));
        assertEquals(1, parkingLot.getCountCarsByColor("Red"));
    }
    @Test
    public void ParkingLotIsFullSoItGivesNegativeValue() {
        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.parkCar(new Car("KA-01-HH-1234", "White"));
        parkingLot.parkCar(new Car("KA-01-HH-9999", "White"));

        assertEquals(-1, parkingLot.parkCar(new Car("KA-01-BB-0001", "Black")));
    }
    @Test (expected = RuntimeException.class)
    public void UnParkaGivenCar() {
        ParkingLot parkingLot = new ParkingLot(2);
//        parkingLot.parkCar(new Car("KA-01-HH-1234", "White"));
//        parkingLot.parkCar(new Car("KA-01-HH-9999", "White"));
        Car car = new Car("KA-01-BB-0001", "Black");
        int slotNumber = parkingLot.parkCar(car);

        assertEquals(car , parkingLot.unParkCar(slotNumber));
        assertEquals(false, parkingLot.isCarParked("KA-01-BB-0001"));
        int slotNumber1 = 1;
        assertEquals(false, parkingLot.unParkCar(slotNumber1));
//        assertTrue(parkingLot.unParkCar(1));
//        assertTrue(parkingLot.unParkCar(2));
        assertEquals(car ,parkingLot.unParkCar(2)); //Unparking a car which is not present in the parking lot

    }

}