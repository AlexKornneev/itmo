package com.ifmo.lesson2;

import java.util.Scanner;

public class Factorial {
    /*
     Создайте программу, вычисляющую факториал натурального числа n, которое
     пользователь введёт с клавиатуры.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long factorial = factorial(n);
        System.out.println(factorial);
    }

    public static long factorial(int n) {
        long b = 1;
        for (int i = n; i > 0; i--) {
            b *= i;
        }
        System.out.println("Факториал числа " + n + " равен " + b);
        return b;
    }
}
