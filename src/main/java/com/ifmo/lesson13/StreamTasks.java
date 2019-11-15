package com.ifmo.lesson13;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTasks {

    static class Person {
        final String name;
        final int age;
        final String country;

        public Person(String name, int age, String country) {
            this.name = name;
            this.age = age;
            this.country = country;
        }
    }

    public static void main(String[] args) {
        Stream<Person> people = generatePeople(100);

        List<String> countries = countriesSortedByTheirPopulationDescending(people);
        String countryThatHasMostKids = countryThatHasMostKids(people);
        //изменил Integer на Long
        Map<String, Long> populationByCountry = populationByCountry(people);

        System.out.println(countries);
        System.out.println(countryThatHasMostKids);
        System.out.println(populationByCountry);

        List<String> words = List.of("the", "hello", "approximation", "greetings", "java", "war");

        Map<Integer, Set<String>> wordsByLength = groupWordsByLength(words);
        int averageWordLength = averageWordLength(words);
        Set<String> longestWords = longestWords(words);

        System.out.println(wordsByLength);
        System.out.println(averageWordLength);
        System.out.println(longestWords);
    }

    // Метод возвращает страны в порядке убывания их населения.
    public static List<String> countriesSortedByTheirPopulationDescending(Stream<Person> people) {
        // групировка это всегда .map
        return people
                .collect(Collectors.groupingBy(p -> p.country, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    // Метод находит страну (или одну из стран), в которых больше всего человек в возрасте
    // до 18 лет.
    public static String countryThatHasMostKids(Stream<Person> people) {
        return people
                .filter(p -> p.age < 18)
                .collect(Collectors.groupingBy(p -> p.country, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("Unknown");

    }

    // Метод возвращает карту стран их населения. Поменял Мар с Integer на Long ... иначе p.country подсвечивается
    public static Map<String, Long> populationByCountry(Stream<Person> people) {
        return people
                .collect(Collectors.groupingBy(p -> p.country, Collectors.counting()));

    }

    // Метод генерирует случайных людей в ограниченном наборе стран.
    // number - число желаемых людей.
    public static List<String> COUNTRES = List.of("USA", "RUSSIA", "UK");
    public static List<String> NAME = List.of("Pol", "Kris", "Alex");


    public static Stream<Person> generatePeople(int number) {
        Random rnd = new Random();
        return Stream.generate(
                () -> new Person(NAME.get(rnd.nextInt(NAME.size())), rnd.nextInt(100), COUNTRES.get(rnd.nextInt(COUNTRES.size())))
        ).limit(number);
    }

    // Метод возвращает карту сгруппированных слов по их длине. Например, для
    // трёхбуквенных слов будет:
    // 3 -> "the", "map", "got", "war"...
    public static Map<Integer, Set<String>> groupWordsByLength(List<String> words) {
        Optional<String> res = Stream.of("Pol", "Kris", "Alex")
                .filter(s -> false)
                .findFirst();
        String r = res.orElse("Not found");
        return Map.of();
    }

    // Метод находит среднюю длину слов в списке.
    public static int averageWordLength(List<String> words) {
        // получаем списокб суммируем длинну все слов и делем на 2
        int sum = words.stream()
                .map(word -> word.length())
                .reduce((a, b) -> a + b)
                .orElse(0);

        return sum / words.size();
    }

    // Метод находит самое длинное слово или слова, если таких несколько.
    public static Set<String> longestWords(List<String> words) {
        // TODO implement.
        int max = words.stream().max(Comparator.comparing(String::length)).orElse("").length();
        return words
                .stream()
                .filter(p -> p.length() == max)
                .collect(Collectors.toSet());

    }
}