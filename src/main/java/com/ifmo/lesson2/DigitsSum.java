package com.ifmo.lesson2;

import java.util.Scanner;

public class DigitsSum {
    /*
    Для введённого пользователем с клавиатуры натурального числа посчитайте сумму всех
    его цифр (заранее не известно сколько цифр будет в числе).
     */
    public static void main(String[] args) {
        boolean success = false;
        do {
            System.out.println("Введите число");
            Scanner scanner = new Scanner(System.in);

            int n = scanner.nextInt();

            int digitSum = digitSum(n);

            System.out.println(digitSum);
            if (success) {

            } else {

                System.out.println("Отлично! Попробуйте еще");
            }
        } while (!success);
    }

    public static Integer digitSum(int n) {
        // TODO implement
        String number = String.valueOf(n);
        int sum = 0;
        for (int i = 0; i < number.length(); i++)
            sum += makeStringToInt(number.charAt(i));
        System.out.println("Сумма чисел равна " + sum);
        return sum;

    }

    private static int makeStringToInt(char item) {
        return Integer.valueOf(String.valueOf(item));
    }
}
