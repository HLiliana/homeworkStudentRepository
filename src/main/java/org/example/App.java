package org.example;

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
 * Verbs: create, addStudent, deleteStudentById,retrieveAllStudentByAge, calculateAge,
 * listAllStudent, orderByLastNAme, orderByBirthDate,validationAge(1900, currentYear-18)
 *
 * Exceptions: exceptionsIdIsEmpty ,exceptionAgeIsNegative,exceptionInputIsEmpty
 * validationFirstAndLastNotEmpty, validationGenderUpperAndLowerCase
 */
public class App {
    public static void main(String[] args) {

    StudentRepository student1 = new StudentRepository("Pop", "Ana",
            Gender.F, new String[]{"6","0","3","0","9","2","6","1","1","1","2","2","2"});

        System.out.println(student1.calculateBirthYear());
        System.out.println(student1.calculateAge());
    }
}
