package com.company;

public class Car implements  Runnable {
    private String id;
    private int distance;
     int speed;      //скорость
     int time;       //время
     int Sspeed;     // средняя скорость
     int PDistance; // пройденное расстояние
     int ODistance; // оставшееся расстояние


    public Car(  int Distance ){
        //this.id = id;
        this.distance = Distance;
    }

    public int GetDistance(){
        return distance;
    }

    @Override
    public void run() {
        while (distance > 0) {

            speed = (int) (Math.random() * 66);
            PDistance = PDistance + speed;
            time = distance/speed;
            Sspeed = distance / time;
            ODistance = distance / Sspeed; // вычисление оставшейся дистанции на основе средней скорости
            distance = distance - ODistance;

            System.out.println("Текущая скорость: " + speed + " м/с");
            System.out.println("Средняя скорость: " + Sspeed + " м/с");
            System.out.println("Осталось ехать: "+ distance + " м");
            System.out.println("Времени до прибытия: "+ ODistance + " мин");
            System.out.println();

            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
