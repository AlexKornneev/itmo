package com.ifmo.lesson2;

public class IsEven {
    /*
    Создать программу, проверяющую и сообщающую на экран, является ли целое число
    записанное в переменную n, чётным либо нечётным.
     */
    public static void main(String[] args) {
        int n = 23;

        System.out.println(isEven(n));
    }

    public static String isEven(int n) {
        // TODO implement
        // Допустимые строки: "Четное" или "Нечетное"
        // если число делится на 2 без остатка, то оно четное, если с остатком то нечетное
        if (n % 2 == 0) {
            return "Четное";
        } else {
            return "Нечетное";
        }
    }
}
