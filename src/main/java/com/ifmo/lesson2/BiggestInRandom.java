package com.ifmo.lesson2;

import java.util.Random;

public class BiggestInRandom {
    /*
     Создать программу, выводящую на экран случайно сгенерированное трёхзначное
     натуральное число и его наибольшую цифру.Примеры работы программы:
     В числе 208 наибольшая цифра 8.
     В числе 774 наибольшая цифра 7.
     В числе 613 наибольшая цифра 6.
     */
    public static Random random = new Random();

    public static void main(String[] args) {

        int rnd = threeDigitRandom();

        String largestDigit = largestDigit(rnd);

        System.out.println(largestDigit);
    }

    public static int threeDigitRandom() {
        return (random.nextInt(899) + 100);
    }

    public static String largestDigit(int rnd) {
        int max = 0;
        // TODO implement
        int a = rnd / 100;
        int b = (rnd - a * 100) / 10;
        int c = rnd - (a * 100 + b * 10);

        if ((a > b) & (a > c))
            max = a;
        if ((b > a) & (b > c))
            max = b;
        else {
            max = c;
        }
        return "В числе " + rnd + " наибольшая цифра " + max + ".";
    }
}