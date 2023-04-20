package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class StudentOrderByBirthdate implements Comparator<Student>{
        private SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        @Override
        public int compare(Student student1, Student student2) {
            try {
                Date birthDate1 = dateFormat.parse(student1.getDateOfBirth(student1.ID));
                Date birthDate2 = dateFormat.parse(student2.getDateOfBirth(student2.ID));
                return birthDate1.compareTo(birthDate2);
            } catch (ParseException e) {
                throw new IllegalArgumentException("Invalid ID format", e);
            }
        }
    }


