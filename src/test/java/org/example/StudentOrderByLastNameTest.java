package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.Collections;import java.util.Collections;


class StudentOrderByLastNameTest {
    @Test
    void compareOrderByLastName() {
        Student student1 = new Student("Pop", "Maria", "female", "2880808111222");
        Student student2 = new Student("Pop", "Ioana", "female", "2880812111222");
        Student student3 = new Student("Pop", "Nicoleta", "female", "2880312111222");

        List<Student> studentList = new ArrayList<>();

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        Collections.sort(studentList, new StudentOrderByLastName());
        assertEquals(student1, studentList.get(1));
        assertEquals(student2, studentList.get(0));
        assertEquals(student3, studentList.get(2));

    }
}