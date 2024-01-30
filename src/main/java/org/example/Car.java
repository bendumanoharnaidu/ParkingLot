package org.example;

public class Car {
    private String registrationNumber;
    private String color;
    public Car(String registrationNumber, String color) {
        //exception handling if registrationNumber or color is null
        this.registrationNumber = registrationNumber;
        this.color = color;
    }
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    public String getColor() {
        return color;
    }
}
