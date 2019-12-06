package com.ifmo.lesson3;

import java.util.Random;

public class Random15 {
    /*
     Создайте массив из 15 случайных целых чисел из отрезка [0;9]. Выведите массив на экран.
     Подсчитайте сколько в массиве чётных элементов и выведете это количество на экран на
     отдельной строке.
     */
    public static Random random = new Random();

    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();
        printArray(randomNumbers);
        int evens = evens(randomNumbers);
        System.out.println(evens);
    }

    public static void printArray(int[] array) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);
            if (i < array.length - 1) {
                builder.append(" ");
            }
        }
        System.out.println(builder);
    }

    public static int[] randomNumbers() {
        int[] array = new int[15];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }
        return array;
    }

    public static int evens(int[] arr) {
        int evens = 0;
        for (int i = 0; i < arr.length; i++) {
            evens = ((arr[i] & 1) == 0) ? evens + 1 : evens;
        }
        return evens;
    }
}
