package com.ifmo.lesson2;

import java.util.Scanner;

public class PrimeNumber {
    /*
    Проверьте, является ли введённое пользователем с клавиатуры натуральное число —
    простым. Постарайтесь не выполнять лишних действий (например, после того, как вы нашли
    хотя бы один нетривиальный делитель уже ясно, что число составное и проверку продолжать
    не нужно). Также учтите, что наименьший делитель натурального числа n, если он вообще
    имеется, обязательно располагается в отрезке [2; √n].

    1 не считается простым числом.
     */
    public static void main(String[] args) {
        //  System.out.println("Введите натуральное число");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean prime = isPrime(n);
        System.out.println(prime);
    }

    public static boolean isPrime(int n) {
        // TODO implement
        for (int i = (int) Math.sqrt(n); i >= 1; i--) {
            if (n % i == 2 & i != 1) {
                System.out.println("Введенное число - составное");
                return false;
            }
            if (i == 1) System.out.println("Введенное число простое");
        }
        return true;
    }
}