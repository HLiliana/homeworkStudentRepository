package org.example;

import java.util.Comparator;

public class StudentOrderByLastName implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2){
        return student1.getLastName().compareToIgnoreCase(student2.getLastName());
    }
}
