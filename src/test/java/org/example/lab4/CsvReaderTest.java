package org.example.lab4;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CsvReaderTest {

    @Test
    void testSize() throws Exception 
    {
        CsvReader reader = new CsvReader();
        List<Person> people = reader.read("foreign_names.csv");
        assertFalse(people.isEmpty());
    }
    @Test
    void testFirstPerson() throws Exception 
    {
        CsvReader reader = new CsvReader();
        List<Person> people = reader.read("foreign_names.csv");
        Person first = people.get(0);

        assertEquals(28281, first.getId());
        assertEquals("Aahan", first.getName());
        assertEquals("Male", first.getGender());
        assertEquals(4800, first.getSalary());
        assertNotNull(first.getDepartment());
        assertNotNull(first.getBirthDate());
    }

    @Test
    void testDepartmentsNotNull() throws Exception 
    {
        CsvReader reader = new CsvReader();
        List<Person> people = reader.read("foreign_names.csv");
        people.forEach(p -> assertNotNull(p.getDepartment()));
    }
    @Test
    void testSameDivisionSameDepartment() throws Exception {
        CsvReader reader = new CsvReader();
        List<Person> people = reader.read("foreign_names.csv");

        List<Person> divI = people.stream()
                .filter(p -> p.getDepartment().getName().equals("I"))
                .toList();

        long ids = divI.stream()
                .map(p -> p.getDepartment().getId())
                .distinct()
                .count();

        assertEquals(1, ids);
    }
}