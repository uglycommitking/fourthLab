package org.example.lab4;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvReader 
{
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public List<Person> read(String path) throws Exception 
    {
        InputStream in = getClass().getClassLoader().getResourceAsStream(path);
        if (in == null) throw new FileNotFoundException(path);

        List<Person> people = new ArrayList<>();
        Map<String, Department> departments = new HashMap<>();

        try (CSVReader reader = new CSVReaderBuilder(new InputStreamReader(in))
                .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                .build()) {

            String[] line;
            reader.readNext();

            while ((line = reader.readNext()) != null) 
            {
                if (line.length < 6) continue;

                int id = Integer.parseInt(line[0].trim());
                String name = line[1].trim();
                String gender = line[2].trim();
                LocalDate birthDate = LocalDate.parse(line[3].trim(), FORMAT);
                String divName = line[4].trim();
                int salary = Integer.parseInt(line[5].trim());

                Department dept = departments.computeIfAbsent(divName, Department::new);
                people.add(new Person(id, name, gender, dept, salary, birthDate));
            }
        }
        return people;
    }
}