package com.ifmo.lesson3;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Random;

public class TwoArrays {
    /*
     Создайте 2 массива из 5 случайных целых чисел из отрезка [0;5] каждый, выведите
     массивы на экран в двух отдельных строках. Посчитайте среднее арифметическое элементов
     каждого массива и сообщите, для какого из массивов это значение оказалось больше (либо
     сообщите, что их средние арифметические равны).
     */

    public static void main(String[] args) {
        int[] randomNumbers1 = randomNumbers();
        printArray(randomNumbers1);
        int[] randomNumbers2 = randomNumbers();
        printArray(randomNumbers1);

        int average1 = average(randomNumbers1);
        int average2 = average(randomNumbers2);

        if (average1 == average2) {
            System.out.println("Значения равны");
        } else if (average1 > average2) {
            System.out.println("Масив 1 больше Масива 2");
        } else {
            System.out.println("Масив 2 больше масива 1");
        }
    }
    public static Random random = new Random();
    public static int[] randomNumbers() {

        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(6);
        }
        return array;
    }

    public static int average(int[] randomNumbers) {

        OptionalDouble averageDouble = Arrays.stream(randomNumbers).average();
        return (int) Math.round(averageDouble.getAsDouble());
    }

    private static void printArray(int[] array) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);
            if (i < array.length - 1) {
                builder.append(" ");
            }
        }
        System.out.println(builder);
    }
}
