package com.ifmo.lesson1;

public class TwoDigitsSum {
    /*
    В переменной n хранится натуральное двузначное число.
    Создайте программу, вычисляющую и выводящую на экран сумму цифр числа n.
     */
    public static void main(String[] args) {
        int n = 23;
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