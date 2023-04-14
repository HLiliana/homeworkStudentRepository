package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;

import static org.example.Gender.F;
import static org.example.Gender.M;

public class Student{
    String firstName;
    String lastName;
    String gender;
    Year currentYear = Year.now();
    String ID;
    private int birthYear = 0;
    String dateOfBirth;
    public Student(String firstName, String lastName, String gender, String ID){
        this.firstName=firstName;
        this.lastName=lastName;
        this.gender=gender;
        this.ID= ID;
    }

    public String getDateOfBirth(String ID) throws ParseException {
        // il vom folosi la order list
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        String dateString = "";

        if (ID.substring(0,1).equals("1") || ID.substring(0,1).equals("2")) {
            dateString = ID.substring(1, 7);
        }
        if (ID.substring(0,1).equals("5") || ID.substring(0,1).equals("6")) {
            dateString = ID.substring(1, 7);
        }
        return dateString;
    }

    /**
     * This validation for gender where is better to be placed in the code logic?
     * Here in class student where we do not allow the student to be added if it`s not valid?
     * Or better to let the student being added, even if it`s ixnvalid, and then catch them in the test running?
     */
    public Gender validationGenderInputFromUser(String gender) {
        if (gender == null) {
            throw new IllegalArgumentException("Gender can not be null. ");
        }
        if (gender.equalsIgnoreCase("MALE") || gender.equalsIgnoreCase("M")) {
            return M;
        }
        if (gender.equalsIgnoreCase("FEMALE") || gender.equalsIgnoreCase("F")) {
            return F;
        }

        return null;
    }

    public int calculateBirthYear() throws ValidationException {
        try{
            Integer.parseInt(ID.substring(0,1));
        }catch(NumberFormatException e){
            System.out.println("First char of the ID must be a number. ");
        }


        int helperYear;
        String helperID = ID.substring(1,3);
        helperYear = (Integer.parseInt(helperID.substring(0,1)) * 10) + (Integer.parseInt(helperID.substring(1,2)));

        if (ID.substring(0,1).equals("1") || ID.substring(0,1).equals("2")) {
            birthYear = 1900 + helperYear;

        } else if (ID.substring(0,1).equals("5") || ID.substring(0,1).equals("6")) {
            birthYear = 2000 + helperYear;
        }
        return birthYear;
    }

    public int calculateAge() throws ValidationException {

        return currentYear.getValue() - calculateBirthYear();
    }

    public void validationAge(Student student) throws ValidationException {
        if (student.calculateAge() < 18) {
            throw new ValidationException("Student under 18 are not allowed.");
        }
    }

    public String getLastName() {
        return lastName;
    }
}
