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
        // TODO implement
        int a;
        long b = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите натуральное число");
        //Проверка, число введенное натуральное или нет
        if (scanner.hasNextInt()) {
            //Число натуральное, переменной а присваивается значение введенного числа
            a = scanner.nextInt();
            // вычисление факториала
            for (int i = a; i > 0; i--) {
                b *= i;
            }
            System.out.println("Факториал числа " + a + " равен " + b);
        } else System.out.println("Ошибка. Введено не число");
        return b;
    }
}
