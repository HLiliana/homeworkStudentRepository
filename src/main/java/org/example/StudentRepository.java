package org.example;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class StudentRepository {
    public List<Student> studentList = new ArrayList<>();
    public List<Student> resultStudentList = new ArrayList<>();
    public int ageUserChoice;

    public void addStudent(Student student) throws ValidationException {
        if (student == null) {
            throw new ValidationException("Student can't be null. ");
        }
        if (student.firstName == null || student.firstName.equalsIgnoreCase("")) {
            throw new ValidationException("First name can not be null. ");
        }
        if (student.lastName == null || student.lastName.equalsIgnoreCase("")) {
            throw new ValidationException("Last name can not be null. ");
        }
        //aici sa mai punem cu dimensiunea array si cifre nu litere
        if (student.ID == null || student.ID.equalsIgnoreCase("")) {
            throw new ValidationException("Student ID can not be null. ");
        }
        studentList.add(student);
        System.out.println("Successfully added student " + student.firstName + " " + student.lastName
                + " to our Student Repository.");
    }

    public void deleteStudentByID(String ID) throws ValidationException {
        for (Student student : studentList) {
            if (student.ID.equalsIgnoreCase(ID)) {
                studentList.remove(student);
                System.out.println(student.firstName + " " + student.lastName +
                        " has been deleted from our student repository. ");
                return;
            }
        }
        throw new ValidationException("Student does not exist. ");
    }

    /**
     * We checked only the string to be formed by numbers and not null.
     * In this method we tried to create a new list with all the student which have
     * the ageUserChoice.
     */
    public List<Student> retrieveAllStudentByAge(String ageUserChoice) throws ValidationException {
        if (ageUserChoice == null) {
            throw new ValidationException("Please enter a number format aaaa. ");
        }
        if (!ageUserChoice.matches("[0-9]+") || ageUserChoice.length() < 1) {
            throw new ValidationException("Please enter a number format age. ");
        }

        int studentAge;

        for (Student student : studentList) {
            studentAge = student.calculateAge();
            if (Integer.parseInt(ageUserChoice) < 0) {
                throw new ValidationException("Please enter a positive age. ");
            }
            if (studentAge == Integer.parseInt(ageUserChoice)) {
                resultStudentList.add(student);
            }
        }
        return resultStudentList;
    }

}
