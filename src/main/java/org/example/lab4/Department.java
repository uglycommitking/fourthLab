package org.example.lab4;

import java.util.concurrent.atomic.AtomicInteger;

public class Department {

    private static final AtomicInteger counter = new AtomicInteger(1);
    private final int id;
    private final String name;

    public Department(String name) 
    {
        this.id = counter.getAndIncrement();
        this.name = name;
    }

    public int getId() 
    { 
        return id; 
    }
    public String getName() 
    { 
        return name; 
    }

    @Override
    public String toString() 
    {
        return "Department{id=" + id + ", name='" + name + "'}";
    }
}