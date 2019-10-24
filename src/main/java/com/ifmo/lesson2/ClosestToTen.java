package com.ifmo.lesson2;

public class ClosestToTen {
    /*
     Создать программу, выводящую на экран ближайшее к 10 из двух чисел, записанных в
     переменные m и n. Например, среди чисел 8,5 и 11,45 ближайшее к десяти 11,45.
     */
    public static void main(String[] args) {
        float m = 8.5f;
        float n = 11.45f;

        float closestToTen = closestToTen(m, n);

        System.out.println(closestToTen);
    }

    // TODO implement
    public static float closestToTen(float a, float b) {
        if (abs(10 - a) > abs(10 - b)) {
            return b;
        } else {
            return a;
        }
    }

    public static float abs(float a){
        if (a<0){
            return a * -1;
        }
        else{
            return a;
        }
    }
}
