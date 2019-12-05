package com.ifmo.lesson3;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Random;

public class Random12 {
    /*
    Создайте массив из 12 случайных целых чисел из отрезка [-15;15]. Определите какой
    элемент является в этом массиве максимальным и сообщите индекс его последнего
    вхождения в массив.
     */
    public static Random random = new Random();

    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();
        int max = max(randomNumbers);
        int maxLastIndex = lastIndexOf(randomNumbers, max);
        System.out.println(maxLastIndex);
    }

    public static int[] randomNumbers() {
        int[] array = new int[12];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(31) - 15;
        }
        return array;
    }

    public static int max(int[] randomNumbers) {
        int max = randomNumbers[0];
        for (int i = 1; i < randomNumbers.length; i++) {
            max = Math.max(max, randomNumbers[i]);
        }
        return max;
    }

    public static int lastIndexOf(int[] randomNumbers, int max) {
        int index = 0;
        for (int i = 0; i < randomNumbers.length; i++) {
            if (randomNumbers[i] == max) {
                index = i;
            }
        }
        return index;
    }
}