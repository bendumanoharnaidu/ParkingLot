package org.example;

import org.example.Exceptions.InvalidException;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class ParkingLot {
    private int capacity;
    private Map<Integer, Car> parkingSlots;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        parkingSlots = new HashMap<>();
    }
    public int parkCar(Car car) throws Exception {
        if(isFull()) {
//            throw new InvalidException("Parking lot is full");
            return -1;
        }
        int id = new Random().nextInt();
        parkingSlots.put(id, car);
        return id;
//        for (Map.Entry<Integer, Car> entry : parkingSlots.entrySet()) {
//            if (entry.getValue()==null) {
//                int id = new Random().nextInt();
//                parkingSlots.put(id, car);
//                return id;
//            }
//        }
//        return -1;
    }
    boolean isFull() {
        return parkingSlots.size() == capacity;
    }

    public Car unParkCar(int token) {
        if (isCarParked(token)) {
//            for (Map.Entry<Integer, Car> entry : parkingSlots.entrySet()) {
//                if (entry.getValue().getRegistrationNumber().equals(registrationNumber)) {
//                    return parkingSlots.remove(entry.getKey());
//                }
//            }
            return parkingSlots.remove(token);
        }
//        if (parkingSlots.containsKey(sl)) {
//
//            return parkingSlots.remove(slotNumber);
//        }
        throw new RuntimeException("No car parked at this slot");
////        return false;
    }
    public boolean isCarParked(int token) {
//        for (Car car : parkingSlots.values()) {
            if (parkingSlots.containsKey(token)) {
                return true;
            }
//        }
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
