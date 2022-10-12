package com.company;

public class
Main {
    public static void main(String[] args) throws InterruptedException {

        Car car = new Car(100);

        new Thread(car).start();
    }
}
