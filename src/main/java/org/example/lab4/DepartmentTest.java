package org.example.lab4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {
    @Test
    void testName() 
    {
        Department d = new Department("A");
        assertEquals("A", d.getName());
    }
    @Test
    void testIdAutoIncrement() 
    {
        Department d1 = new Department("X");
        Department d2 = new Department("Y");
        assertTrue(d2.getId() > d1.getId());
    }

    @Test
    void testToString() 
    {
        Department d = new Department("B");
        assertTrue(d.toString().contains("B"));
    }
}