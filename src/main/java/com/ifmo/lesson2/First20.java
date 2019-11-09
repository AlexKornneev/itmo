package com.ifmo.lesson2;

public class First20 {
    private static int lastNumber;

    /*
         Создайте программу, выводящую на экран первые 20 элементов последовательности 2 4 8
         16 32 64 128 ….
         */
    public static void main(String[] args) {
        // TODO implement
        // задаем цикл который будет увеличивать значение "а" на один, и умножать значение "в"
        for (int a = 1, b = 2; a <= 20; a++, b *= 2)
            System.out.println(b + " ");
    }

}