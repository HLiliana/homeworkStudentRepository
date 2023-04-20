package org.example;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void calculateBirthYear() throws ValidationException {
        Student student1 = new Student("Pop", "Ana",
                "female", "6030606111222");
        assertEquals(2003, student1.calculateBirthYear());
    }
    @Test
    void calculateBirthYearInvalidID() throws ValidationException {
        Student student1 = new Student("Pop", "Ana",
                "female", "9030606111222");
       assertThrows(ValidationException.class, () -> student1.calculateBirthYear());
    }
    @Test
    void calculateAge() throws ValidationException {
        Student student1 = new Student("Pop", "Ana",
                "female", "2940505111222");
        student1.calculateBirthYear();
        assertEquals(29, student1.calculateAge());
    }

    @Test
    void getDateOfBirth() throws ParseException {
        Student student1 = new Student("Pop", "Ana",
                "female", "6030606111222");
        assertEquals("030606", student1.getDateOfBirth(student1.ID));
    }

    @Test
    void validationGenderNullInputFromUser() throws IllegalArgumentException {
        Student student1 = new Student("Pop", "Ana",
                null, "2940505111222");
        assertThrows(IllegalArgumentException.class,
                () -> student1.validationGenderInputFromUser(null));
    }


}