package com.company;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    private int arrsp[] = new int[5];
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CAR car = new CAR(10);
        new Thread(car).start();

    }
}
