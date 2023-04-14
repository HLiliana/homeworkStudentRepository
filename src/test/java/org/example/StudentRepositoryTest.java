package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    @Test
    void addStudent() throws ValidationException {
        StudentRepository studentRepository = new StudentRepository();
        List<Student> studentList = new ArrayList<>();

        studentRepository.addStudent(new Student("Pop", "Maria", "female", "2880808111222"));
        studentRepository.addStudent(new Student("Pop", "Maria", "female", "2880812111222"));
        studentRepository.addStudent(new Student("Pop", "Maria", "female", "2880312111222"));

        assertEquals(3, studentRepository.studentList.size());
    }

    @Test
    void deleteStudentByInvalidID() throws ValidationException {

        StudentRepository studentRepository = new StudentRepository();
        List<Student> studentList = new ArrayList<>();

        studentRepository.addStudent(new Student("Pop", "Maria", "female", "2880808111222"));
        studentRepository.addStudent(new Student("Pop", "Maria", "female", "2880812111222"));
        studentRepository.addStudent(new Student("Pop", "Maria", "female", "2880312111222"));

        try {
            studentRepository.deleteStudentByID("2880108111222");
        } catch (IllegalArgumentException e) {
            assertEquals("Student does not exist. ", e.getMessage());
        }

    }
    @Test
    void deleteStudentByInValidID() throws ValidationException {

        StudentRepository studentRepository = new StudentRepository();
        List<Student> studentList = new ArrayList<>();

        studentRepository.addStudent(new Student("Pop", "Maria", "female", "2880808111222"));
        studentRepository.addStudent(new Student("Pop", "Maria", "female", "2880812111222"));
        studentRepository.addStudent(new Student("Pop", "Maria", "female", "2880312111222"));

        studentRepository.deleteStudentByID("2880808111222");
        assertEquals(2, studentRepository.studentList.size());


    }

    @Test
    void retrieveAllStudentByAge() throws ValidationException {
        StudentRepository studentRepository = new StudentRepository();

        studentRepository.addStudent(new Student("Pop", "Maria", "female", "2890808111222"));
        studentRepository.addStudent(new Student("Pop", "Maria", "female", "2880812111222"));
        studentRepository.addStudent(new Student("Pop", "Maria", "female", "2840312111222"));

        List<Student> studentList = studentRepository.retrieveAllStudentByAge("34");

        assertEquals(1,studentList.size());

    }
}
