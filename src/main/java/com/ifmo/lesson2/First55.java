package com.ifmo.lesson2;

public class First55 {
    /*
    Создайте программу, выводящую на экран первые 55 элементов последовательности 1 3 5 7 9 11 13 15 17 ….
     */
    public static void main(String[] args) {
        // TODO implement
        // задаем цикл который будет увеличивать значение "а" на один, и пробавлять значению "в" число 2
        for (int a = 1, b = 1; a <= 55; a++, b = b + 2)
            System.out.println(b + " ");
    }
}
