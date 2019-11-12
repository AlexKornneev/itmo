package com.ifmo.lesson2;

import java.util.Arrays;

public class SquareEquation {
    /*
     В три переменные a, b и c записаны три вещественных числа. Создать программу, которая
     будет находить и выводить на экран вещественные корни квадратного уравнения ax²+bx+c=0,
     либо сообщать, что корней нет.
     */
    public static void main(String[] args) {
        double a = 2;
        double b = -9;
        double c = 9;

        double[] roots = squareEquationRoots(a, b, c);

        System.out.println(Arrays.toString(roots));
    }

    /*
    Возвращает массив из двух корней или null, если таковых нет.
     */
    private static double[] squareEquationRoots(double a, double b, double c) {
        double d = (b * b) - (4 * a * c);
        double e = 0;
        double f = 0;
        if (d == 0) {
            e = -1 * (b / (2 * a));
            System.out.println("1 корень");
        } else {
            if (d > 0) {
                e = ((-1 * b) + Math.sqrt(d)) / (2 * a);
                f = ((-1 * b) - Math.sqrt(d)) / (2 * a);
                System.out.println("2 корня");
            } else {
                return null;
            }
        }
        return new double[(int) d];
    }
}