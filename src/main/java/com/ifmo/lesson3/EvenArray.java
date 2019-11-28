package com.ifmo.lesson3;

public class EvenArray {
    /*
    Создайте массив из всех чётных чисел от 2 до 20 и выведите элементы массива на экран
    сначала в строку, отделяя один элемент от другого пробелом, а затем в столбик (отделяя один
    элемент от другого началом новой строки). Перед созданием массива подумайте, какого он
    будет размера.2 4 6 … 18 20246…20
     */
    public static void main(String[] args) {
        int[] evenArray = evenArray();

    }

    public static int[] evenArray() {
        int a = 0;
        for (int i = 2; i <= 20; i++) {
            if (i % 2 == 0) a++;
        }
        int[] evenArray = new int[a];
        for (int i = 2, b = 0; i <= 20; i++) {
            if (i % 2 == 0) {
                evenArray[b] = i;
                System.out.print(evenArray[b] + " ");
                b++;
            }
        }

        System.out.println(" ");
        for (int i = 0; i < evenArray.length; i++) {
            System.out.println(evenArray[i]);
        }
        return evenArray;
    }
}