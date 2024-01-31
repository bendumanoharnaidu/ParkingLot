package org.example;

import org.example.Exceptions.InvalidException;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingLotTest {
    @Test
    public void testParkingLot() throws Exception {
        ParkingLot parkingLot = new ParkingLot(6);
        int token1 = parkingLot.parkCar(new Car("KA-01-HH-1234", "White"));
        int token2 = parkingLot.parkCar(new Car("KA-01-HH-9999", "White"));
        int token3 = parkingLot.parkCar(new Car("KA-01-BB-0001", "Black"));
        int token4 = parkingLot.parkCar(new Car("KA-01-HH-7777", "Red"));
        int token5 = parkingLot.parkCar(new Car("KA-01-HH-2701", "Blue"));
        int token6 = parkingLot.parkCar(new Car("KA-01-HH-3141", "Black"));


        assertTrue(parkingLot.isCarParked(token1));
        assertEquals(-1, parkingLot.parkCar(new Car("KA-01-HH-4321", "White")));
//        assertThrows(InvalidException.class , () -> parkingLot.parkCar(new Car("KA-01-HH-1234", "White")));


    }
    @Test
    public void CheckIfCarIsParkedOrNot() throws Exception {
        ParkingLot parkingLot = new ParkingLot(4);
        int token1 = parkingLot.parkCar(new Car("KA-01-HH-1234", "White"));
        int token2 = parkingLot.parkCar(new Car("KA-01-HH-9999", "White"));
        int token3 = parkingLot.parkCar(new Car("KA-01-BB-0001", "Black"));
        int token4 = parkingLot.parkCar(new Car("KA-01-HH-7777", "Red"));

        assertTrue(parkingLot.isCarParked(token1));
        assertTrue(parkingLot.isCarParked(token2));
//        assertEquals(false, parkingLot.isCarParked("KA-01-HH-0000"));

    }
    @Test
    public void getCountOfCarsByColor() throws Exception {
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
    public void ParkingLotIsFullSoItGivesNegativeValue() throws Exception {
        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.parkCar(new Car("KA-01-HH-1234", "White"));
        parkingLot.parkCar(new Car("KA-01-HH-9999", "White"));

        assertEquals(-1, parkingLot.parkCar(new Car("KA-01-BB-0001", "Black")));
    }
    @Test
    public void UnParkaGivenCar() throws Exception {
        ParkingLot parkingLot = new ParkingLot(2);
//        parkingLot.parkCar(new Car("KA-01-HH-1234", "White"));
//        parkingLot.parkCar(new Car("KA-01-HH-9999", "White"));
        Car car = new Car("KA-01-BB-0001", "Black");
        int Token1 = parkingLot.parkCar(car);
        assertTrue(parkingLot.isCarParked(Token1));
        parkingLot.unParkCar(Token1);
        assertEquals(false,parkingLot.isCarParked(Token1));

//        assertEquals(car , parkingLot.unParkCar("KA-01-BB-0001"));
//        assertEquals(false, parkingLot.isCarParked("KA-01-BB-0001"));
//        int slotNumber1 = 1;
//        assertEquals(false, parkingLot.unParkCar("KA-01-BB-0001"));
//        assertTrue(parkingLot.unParkCar(1));
//        assertTrue(parkingLot.unParkCar(2));
//        assertEquals(car ,parkingLot.unParkCar(2)); //Unparking a car which is not present in the parking lot

    }

}