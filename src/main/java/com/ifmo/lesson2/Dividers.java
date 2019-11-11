package com.ifmo.lesson2;

import java.util.Scanner;

public class Dividers {
    /*
    Выведите на экран все положительные делители натурального числа, введённого
    пользователем с клавиатуры.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите натуральное число");
        int n = scanner.nextInt();
        // TODO implement
        System.out.print("Делителями числа " + n + " являются ");
        for (int i = n; i > 0; i--) {
            int b = n % i;
            if (b == 0)
                System.out.print(i + " ");
        }
//        } else System.out.println("Ошибка. Введено не число");
    }
}