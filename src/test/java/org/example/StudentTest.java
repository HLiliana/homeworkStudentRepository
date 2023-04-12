package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void calculateBirthYear() {
        Student student1 = new Student("Pop", "Ana",
                "female", "6030606111222");
        assertEquals(2003,student1.calculateBirthYear());
    }

    @Test
    void calculateAge() {
        Student student1 = new Student("Pop", "Ana",
                "female", "2940505111222");
        student1.calculateBirthYear();
        assertEquals(29,student1.calculateAge());
    }
}