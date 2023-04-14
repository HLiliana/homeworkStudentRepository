package org.example;

import java.util.Collections;
import java.util.List;

/**
 * DESCRIPTION
 * <p>
 * create a Student repository which supports // studentRepository ,create
 * add student - exceptions when validating conditions mentioned bellow // addStudent, exceptions
 * delete student (by ID - identifier) - exceptions: ID is empty, student does not exist
 * // deleteStudentById, exceptionsIdIsEmpty
 * retrieve all students with age X (for each student the age must be calculated, not stored in a field)
 * //retrieveAllStudentByAge, calculateAge
 * - exceptions: age is not a number, age is negative // exceptionAgeIsNegative
 * list students and order by Last Name or Birth Date // listAllStudent, orderByLastName, orderByBirthDate
 * - exceptions: any input is empty // exceptionInputIsEmpty
 * these methods must validate inputs and throw exceptions if necessary
 * <p>
 * NOTES
 * <p>
 * for each Student the following information needs to be collected
 * First Name //firstName
 * Last Name //lastNAme
 * Date of Birth //dateOfBirth
 * Gender //gender
 * ID (CNP) // ID
 * <p>
 * the following validations are expected
 * date of birth between 1900 and current year - 18 // currentYear, validationAge(1900, currentYear-18)
 * first name and last name should not be empty //validationFirstAndLastNotEmpty
 * gender should be male or female (or M and F), upper / lower case should both be accepted // validationGenderUpperAndLowerCase
 * for all the validations, the corresponding exception(s) should be thrown
 * <p>
 * when a Student is created with data which breaks the validation constraint
 * the testing application can demonstrate the implementation of the above requirements
 * without requiring a special menu for creating the students or for choosing the operation
 * create several test methods which perform separately a given scenario
 * additionally, you should use Logger for tracing and error handling
 *
 * Noun:  studentRepository ,firstName,lastNAme,dateOfBirth,gender,ID, currentYear
 *
 * Verbs: create, addStudent, deleteStudentById, retrieveAllStudentByAge, calculateAge,
 * listAllStudent - orderByLastNAme || orderByBirthDate, validationAge(1900, currentYear-18)
 *
 * Exceptions: exceptionsIdIsEmpty , exceptionAgeIsNegative, exceptionInputIsEmpty
 * validationFirstAndLastNotEmpty, validationGenderUpperAndLowerCase
 */
public class App {
    public static void main(String[] args) throws ValidationException {

        StudentRepository studentRepository = new StudentRepository();

        try{
        studentRepository.addStudent(new Student("", "Pop", "male",
                "6030325111222"));
       }catch (ValidationException e){
            System.out.println("Please input a valid First Name. " + e.getMessage());
        }

        try{
            studentRepository.addStudent(new Student("Ana", "", "male",
                   "6040909111222"));
        }catch (ValidationException e){
            System.out.println("Please input a valid Last Name. " + e.getMessage());
        }

        try{
            studentRepository.addStudent(new Student("Ana", "Pop", "female",
                    "2910505111222"));

        }catch (ValidationException e){
            System.out.println("Please input a valid First Name. " + e.getMessage());
        }

        // un student nou instantiat care verifica gender sa accepte lower and upper
        studentRepository.addStudent(new Student("Pop", "Ana", "Female",
                "2940706111222"));
        studentRepository.addStudent(new Student("Rus", "Ioana", "Female",
                "2940606111222"));
        studentRepository.addStudent(new Student("Ionescu", "Maria", "Female",
                    "2910806111222"));


        System.out.println(studentRepository.studentList.get(1).validationGenderInputFromUser(studentRepository.
                studentList.get(1).gender));

        System.out.println("Student repository size is " + studentRepository.studentList.size());

        studentRepository.deleteStudentByID(studentRepository.studentList.get(2).ID);

        Collections.sort(studentRepository.studentList, new StudentOrderByBirthdate());
        Collections.sort(studentRepository.studentList, new StudentOrderByLastName());

//      la acest sout nu returneaza lista
//        System.out.println(studentRepository.retrieveAllStudentByAge("kkk"));


    }
}
