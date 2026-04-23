package org.example.lab4;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        CsvReader reader = new CsvReader();
        List<Person> people = reader.read("foreign_names.csv");

        System.out.println("Загружено людей: " + people.size());
        people.stream().limit(5).forEach(System.out::println);
    }
}