package org.example;

import java.util.List;

public class Attendant {
    private List<ParkingLot> parkingLots;
    public Attendant(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }
    public int parkCar(Car car) throws Exception {
        for (ParkingLot lot : parkingLots) {
            int slotNumber = lot.parkCar(car);
            if (slotNumber != -1) {
                return slotNumber;
            }
        }
        return -1;
    }
    public Car unparkCar(int token) {
        for (ParkingLot lot : parkingLots) {
            if (lot.isCarParked(token)) {
                return lot.unParkCar(token);
            }
        }
        throw new RuntimeException("No Car with registration number");
    }
    public boolean isCarParked(int token) {
        for (ParkingLot lot : parkingLots) {
            if (lot.isCarParked(token)) {
                return true;
            }
        }
        return false;
    }
    public boolean isParkingLotFull() {
        for (ParkingLot lot : parkingLots) {
            if (!lot.isFull()) {
                return false;
            }
        }
        return true; // All parking lots are full
    }
    public int getCountCarsByColor(String color) {
        int count = 0;
        for (ParkingLot lot : parkingLots) {
            count += lot.getCountCarsByColor(color);
        }
        return count;
    }
}
