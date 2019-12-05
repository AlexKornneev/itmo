package com.ifmo.lesson3;

public class Fibonacci20 {
    /*
    Создайте массив из 20-ти первых чисел Фибоначчи и выведите его на экран. Напоминаем,
    что первый и второй члены последовательности равны единицам, а каждый следующий —
    сумме двух предыдущих.
     */
    public static void main(String[] args) {
        int[] fibonacciNumbers = fibonacciNumbers();
        fibNum(fibonacciNumbers);
    }

    public static int[] fibonacciNumbers() {
        int[] Mas = new int[20];
        for (int i =0; i<Mas.length; i++){
            if (i<2){
                Mas[i] = 1;
            }
            else {
                Mas[i] = Mas[i-2]+ Mas[i-1];
            }
        }
        return Mas;
    }
    private static void fibNum(int[] array){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);
            if(i < array.length - 1){
                builder.append(" ");
            }
        }
        System.out.println(builder);
    }
}
