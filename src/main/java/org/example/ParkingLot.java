package org.example;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int capacity;
    private Map<Integer, Car> parkingSlots;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        parkingSlots = new HashMap<>();
    }
    public int parkCar(Car car) {
        if(isFull()) {
            return -1;
        }
        for (int i = 1; i <= capacity; i++) {

            if(parkingSlots.containsKey(i) && parkingSlots.get(i).equals(car)) {
                return -1;
            }
            if (!parkingSlots.containsKey(i)) {
                parkingSlots.put(i, car);
                return i;
            }
        }
        return -1;
    }
    private boolean isFull() {
        return parkingSlots.size() == capacity;
    }

    public Car unParkCar(int slotNumber) {
        if (parkingSlots.containsKey(slotNumber)) {

            return parkingSlots.remove(slotNumber);
        }
        throw new RuntimeException("No car parked at this slot");
//        return false;
    }
    public boolean isCarParked(String registrationNumber) {
        for (Car car : parkingSlots.values()) {
            if (car.getRegistrationNumber().equals(registrationNumber)) {
                return true;
            }
        }
        return false;
    }
    public int getCountCarsByColor(String color) {
        int count = 0;
        for (Car car : parkingSlots.values()) {
            if (car.getColor().equals(color)) {
                count++;
            }
        }
        return count;
    }

}
