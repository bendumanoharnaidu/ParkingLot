package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class AttendantTest {
    private Attendant attendant;
    private List<ParkingLot> parkingLots;
    @Test
    public void parkCar() throws Exception {
        parkingLots = new ArrayList<>();

        ParkingLot parkingLot1 = new ParkingLot(2);
        parkingLots.add(parkingLot1);

        ParkingLot parkingLot2 = new ParkingLot(1);
        parkingLots.add(parkingLot2);
        attendant = new Attendant(parkingLots);

        Car car1 = new Car("KA-01-HH-1234", "White");
        Car car2 = new Car("KA-01-HH-9999", "White");
        int token1 = attendant.parkCar(car1);
        int token2 = attendant.parkCar(car2);

        Car car3 = new Car("KA-01-BB-0001", "Black");
        int token3 = attendant.parkCar(car3);

        assertTrue(parkingLot2.isFull());

//        assertEquals(1, parkingLotAttendant.parkCar(car1));
//        assertEquals(2, parkingLotAttendant.parkCar(car2));
//        assertEquals(1, parkingLotAttendant.parkCar(new Car("DEF456", "Green")));
//        assertEquals(-1, parkingLotAttendant.parkCar(new Car("CDEF4567", "Green")));
//        parkingLotAttendant.unparkCar()

        assertTrue(attendant.isCarParked(token1));
        assertTrue(attendant.isCarParked(token2));
//        assertFalse(parkingLotAttendant.isCarParked("CDEF4567"));
    }
    @Test
    public void unparkCar() throws Exception {
        parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(2));
        parkingLots.add(new ParkingLot(1));
        attendant = new Attendant(parkingLots);

        Car car1 = new Car("KA-01-HH-1234", "White");
        Car car2 = new Car("KA-01-HH-9999", "White");

        int token1 = attendant.parkCar(car1);
        int token2 = attendant.parkCar(car2);

        assertTrue(attendant.isCarParked(token1));
        assertTrue(attendant.isCarParked(token2));
        attendant.unparkCar(token1);
        assertFalse(attendant.isCarParked(token1));
    }
    @Test
    public void testIfParkingLotIsFull() throws Exception {
        parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(2));
        parkingLots.add(new ParkingLot(1));
        attendant = new Attendant(parkingLots);

        int token1 = attendant.parkCar(new Car("KA-01-HH-1234", "White"));
        int token2 = attendant.parkCar(new Car("KA-01-HH-9999", "White"));
        int token3 = attendant.parkCar(new Car("KA-01-BB-0001", "Black"));


        assertTrue(attendant.isParkingLotFull());
        attendant.unparkCar(token1);
        assertFalse(attendant.isParkingLotFull());
    }
    @Test
    public void testGetCountCarsByColor() throws Exception {
        parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(2));
        parkingLots.add(new ParkingLot(1));
        attendant = new Attendant(parkingLots);

        Car car1 = new Car("KA-01-HH-1234", "White");
        Car car2 = new Car("KA-01-HH-9999", "White");
        Car car3 = new Car("KA-01-HH-1234", "Black");
        int token1 = attendant.parkCar(car1);
        int token2 = attendant.parkCar(car2);
        int token3 = attendant.parkCar(car3);

        assertEquals(2, attendant.getCountCarsByColor("White"));
        assertEquals(1, attendant.getCountCarsByColor("Black"));
        assertEquals(0, attendant.getCountCarsByColor("Red"));
    }

    //
    @Test
    public void OneParkingLotCanBeAssignedToTheMultipleAttendent() throws Exception {
        ParkingLot parkingLot = new ParkingLot(2);
        Attendant attendant1 = new Attendant(Arrays.asList(parkingLot));
        Attendant attendant2 = new Attendant(Arrays.asList(parkingLot));
        Car car1 = new Car("KA-01-HH-1234", "White");
        Car car2 = new Car("KA-01-HH-9999", "White");
        int token1 = attendant1.parkCar(car1);
        int token2 = attendant2.parkCar(car2);
        assertTrue(parkingLot.isFull());
    }
}