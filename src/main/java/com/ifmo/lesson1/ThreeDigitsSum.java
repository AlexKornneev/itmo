package com.ifmo.lesson1;

import javax.management.StringValueExp;

public class ThreeDigitsSum {
    /*
    В переменной n хранится натуральное трёхзначное число.
    Создайте программу, вычисляющую и выводящую на экран сумму цифр числа n.
     */
    public static void main(String[] args) {
        int n = 123;
        int sum = sum(n);
        System.out.println(sum);
    }

    public static int sum(int n) {
        // TODO implement
        int sum = 0;
        String qwe = String.valueOf(n);
        String[] a = qwe.split("");
        for (int i = 0; i < a.length; i++) {
            sum = sum + Integer.parseInt(a[i]);
        }
        return sum;
    }
}
