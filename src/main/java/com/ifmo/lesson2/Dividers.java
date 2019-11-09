package com.ifmo.lesson2;

import java.util.Scanner;

public class Dividers {
    /*
    Выведите на экран все положительные делители натурального числа, введённого
    пользователем с клавиатуры.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // TODO implement
        System.out.println("Введите натуральное число");
        // проверка положительное число или нет
        if (scanner.hasNextInt()) {
            //Если проверка пройдена, перемменой а присваивается значение введенного числа
            int a;
            a = scanner.nextInt();
            System.out.print("Делителями числа " + a + " являются ");
            for (int i = a; i > 0; i--) {
                int b = a % i;
                if (b == 0)
                    System.out.print(i + " ");
            }
        } else System.out.println("Ошибка. Введено не число");
    }
}