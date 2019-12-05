//package com.ifmo.lesson21;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.util.*;
//import java.util.concurrent.Executors;
//
//public class TopWords {
//    private static Map<String, Integer> totalWordCount = new HashMap<>();
//
//    public static void main(String[] args) throws IOException, InterruptedException {
//        int cpu = Runtime.getRuntime().availableProcessors();
//        final List<String> word = readWords();
//        final List<WordCountThread> threds = new ArrayList<>(cpu);
//        final int partSize = word.size() / cpu;
//        for (int i = 0; i < cpu; i++) {
//            List<String> partWords = new ArrayList<>(word.subList(i * partSize, (i + 1) * partSize));
//            threds.add(new WordCountThread(partWords));
//        }
//        for (WordCountThread thread : threds) {
//            thread.start();
//        }
//        for (WordCountThread thread : threds) {
//            thread.join();
//        }
//        //join
//        //найтти топ 10 слов и вывести
//    }
//
//    private static class WordCountThread extends Thread {
//        private final List<String> words;
//
//        private WordCountThread(List<String> words) {
//            this.words = words;
//            ExecutorService pool = Executors.newFixedThreadPool(3);
//            pool.submit(Foo::foo);
//            pool.submit(() -> bar());
//            pool.submit(new Runnable()
//        }
//
//        @Override
//        public void run() {
//            super.run();
//        }
//    }
//
//    public TopWords() throws IOException {
//    }
//
//    private static List<String> readWords() throws IOException {
//        // Создаем файл, указывая путь к текстовому файлу на диске
//        File text = new File("src\\main\\resources\\wap.txt");
//
//        // Вычитываем все строки из файла
//        List<String> lines = Files.readAllLines(text.toPath());
//
//        // Создаем пустую коллекцию для слов.
//        List<String> words = new ArrayList<>();
//
//        for (String line : lines) {
//            // Для каждой строки
//            String[] wordSplit =
//                    line.toLowerCase() // Переводим в нижний регистр
//                            .replaceAll("\\pP", " ") // Заменяем все знаки на пробел
//                            .trim() // Убираем пробелы в начале и конце строки.
//                            .split("\\s"); // Разбиваем строки на слова
//
//            for (String s : wordSplit) {
//                // Выбираем только непустые слова.
//                if (s.length() > 0)
//                    words.add(s.trim());
//            }
//        }
//        return words;
//    }
//}