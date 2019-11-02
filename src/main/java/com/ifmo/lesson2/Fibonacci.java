package com.ifmo.lesson2;

public class Fibonacci {
    /*
     Выведите на экран первые 11 членов последовательности Фибоначчи. Напоминаем, что
     первый и второй члены последовательности равны единицам, а каждый следующий — сумме
     двух предыдущих.
     */
    public static void main(String[] args) {
        // TODO implement
        int a = 1;
        int b = 1;
        System.out.print(a + " " + b);
        int x = 9;
        int i = 0;
        int sum = 0;
        for (i = 0; i < x; i++) {
            sum = a + b;
            a = b;
            b = sum;
            System.out.print(" " + sum);
        }
    }
}