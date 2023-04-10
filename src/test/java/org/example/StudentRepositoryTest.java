package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    @Test
    void calculateBirthYear() {
        StudentRepository student1 = new StudentRepository("Pop", "Ana",
                Gender.F, new String[]{"6","0","3","0","9","2","6","1","1","1","2","2","2"});
        assertEquals(2003,student1.calculateBirthYear());
    }

    @Test
    void calculateAge() {
        StudentRepository student1 = new StudentRepository("Pop", "Ana",
                Gender.F, new String[]{"1","9","3","0","9","2","6","1","1","1","2","2","2"});
        student1.calculateBirthYear();
        assertEquals(30,student1.calculateAge());
    }
}