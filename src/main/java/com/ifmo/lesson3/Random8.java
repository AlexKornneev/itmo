package com.ifmo.lesson3;

import java.util.Random;

public class Random8 {
    /*
    Создайте массив из 8 случайных целых чисел из отрезка [1;10]. Выведите массив на экран
    в строку. Замените каждый элемент с нечётным индексом на ноль. Снова выведете массив на
    экран на отдельной строке.
     */
    private static Random random = new Random();

    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();
        printArray(randomNumbers);
        int[] replaceWithZeros = replaceWithZeros(randomNumbers);
        printArray(replaceWithZeros);

    }

    public static int[] randomNumbers() {
        int[] array = new int[8];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10) + 1;
        }
        return array;
    }

    public static int[] replaceWithZeros(int[] randomNumbers) {
        // этим цыклом просматрваем значения элементов и если значение нечетное - заменяем его на 0
            for(int i=0;i<randomNumbers.length;i++){
                if(randomNumbers[i]%2!=0)randomNumbers[i]=0;
            }

        return randomNumbers;
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

}