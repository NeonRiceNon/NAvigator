package com.company;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CAR implements Runnable {
    private int min = 10;           //мин.скорость
    private int max = 80;           //макс.скорость
    private float km;               //дистанция
    private int time = 0;           //время в пути
    private int speed = 0;          //скорость
    private float sr = 0;           //ср. скор
    private float speedForM = 0;    //Скорость за метр

    private Random randomSpeed = new Random();


    public CAR(int km) {
        this.km = km * 1000;
    }

    public float getkm() {
        return km;
    }

    @Override
    public void run() {
        while (km > 0) {
            speed = randomSpeed.nextInt(max - min) + min;       //Рандом скорость км в час (60)

            km = km - speed*0.28f;                  // уменьшаем км (1000-16.6680)
            time = time + 1;                        // Прибавляем время
            speedForM = speedForM + speed*0.28f;    //Скорость за Километр
            sr = speedForM / time;                  //средняя скорость - Скорость за метр/время
            int ost = (int) (km / sr);              //Оставшийся ПУТЬ


            System.out.println(" Осталось: " + getkm() + " м");
            System.out.println(" Скорость: " + speed +" км/ч");
            System.out.println(" Время пути: " + time + " с");
            System.out.println(" Средняя скорость: " + String.format("%.3f", (sr)) +  " м/с");
            System.out.println(" Время прибытия: " + ost + " сек");
            System.out.println();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
