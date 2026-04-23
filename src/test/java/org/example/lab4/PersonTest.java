package org.example.lab4;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest 
{

    private Person makePerson() {
        Department d = new Department("A");
        return new Person(1, "John", "Male", d, 5000, LocalDate.of(1990, 1, 1));
    }
    @Test
    void testFields() 
    {
        Person p = makePerson();
        assertEquals(1, p.getId());
        assertEquals("John", p.getName());
        assertEquals("Male", p.getGender());
        assertEquals(5000, p.getSalary());
        assertEquals(LocalDate.of(1990, 1, 1), p.getBirthDate());
    }
    @Test
    void testDepartment() 
    {
        Person p = makePerson();
        assertNotNull(p.getDepartment());
        assertEquals("A", p.getDepartment().getName());
    }
    @Test
    void testToString() 
    {
        Person p = makePerson();
        assertTrue(p.toString().contains("John"));
        assertTrue(p.toString().contains("Male"));
    }
}