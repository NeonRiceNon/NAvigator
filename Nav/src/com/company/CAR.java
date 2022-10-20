package com.company;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CAR implements Runnable {
    private int min = 10;           //���.��������
    private int max = 80;           //����.��������
    private float km;               //���������
    private int time = 0;           //����� � ����
    private int speed = 0;          //��������
    private float sr = 0;           //��. ����
    private float speedForM = 0;    //�������� �� ����

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
            speed = randomSpeed.nextInt(max - min) + min;       //������ �������� �� � ��� (60)

            km = km - speed*0.28f;                  // ��������� �� (1000-16.6680)
            time = time + 1;                        // ���������� �����
            speedForM = speedForM + speed*0.28f;    //�������� �� ��������
            sr = speedForM / time;                  //������� �������� - �������� �� ����/�����
            int ost = (int) (km / sr);              //���������� ����


            System.out.println(" ��������: " + getkm() + " �");
            System.out.println(" ��������: " + speed +" ��/�");
            System.out.println(" ����� ����: " + time + " �");
            System.out.println(" ������� ��������: " + String.format("%.3f", (sr)) +  " �/�");
            System.out.println(" ����� ��������: " + ost + " ���");
            System.out.println();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
