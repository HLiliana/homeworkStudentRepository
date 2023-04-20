package org.example;
import java.util.Collections;


import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentOrderByBirthdateTest {

    @Test
    void compareStudentOrderByBirthdate() throws ParseException {
        Student student1 = new Student("Pop", "Maria", "female", "2880808111222");
        Student student2 = new Student("Pop", "Maria", "female", "2880812111222");
        Student student3 = new Student("Pop", "Maria", "female", "2880312111222");

        List<Student> studentList = new ArrayList<>();

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        Collections.sort(studentList, new StudentOrderByBirthdate());
        assertEquals(student3, studentList.get(0));
        assertEquals(student1, studentList.get(1));
        assertEquals(student2, studentList.get(2));
    }

    @Test
    void compareStudentWithInvalidIDException() throws ParseException {
        Student student1 = new Student("Pop", "Maria", "female", "2880808111222");
        Student student2 = new Student("Ionescu", "Maria", "female", "300000002-2");

        StudentOrderByBirthdate orderByBirthdate = new StudentOrderByBirthdate();

        assertThrows(IllegalArgumentException.class, () ->
                orderByBirthdate.compare(student1, student2));
        }
    }
