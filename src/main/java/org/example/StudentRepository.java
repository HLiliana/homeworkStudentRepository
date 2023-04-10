package org.example;

import java.time.Year;

public class StudentRepository {
    String firstName;
    String lastName;
    Gender gender;
    Year currentYear = Year.now();
    String[] ID = new String[13];
    private int birthYear = 0;
    public StudentRepository(String firstName,String lastName, Gender gender, String [] ID){
        this.firstName=firstName;
        this.lastName=lastName;
        this.gender=gender;
        this.ID= ID;
    }

    public int calculateBirthYear() {

        int helperYear;
        String[] helperID = new String[]{ID[1], ID[2]};
        helperYear = (Integer.parseInt(helperID[0]) * 10) + (Integer.parseInt(helperID[1]));


        if (ID[0].equals("1") || ID[0].equals("2")) {
            birthYear = 1900 + helperYear;

        } else if (ID[0].equals("5") || ID[0].equals("6")) {
            birthYear = 2000 + helperYear;
        }
        return birthYear;
    }
    public int calculateAge(){
        return currentYear.getValue() - birthYear;
    }
}
