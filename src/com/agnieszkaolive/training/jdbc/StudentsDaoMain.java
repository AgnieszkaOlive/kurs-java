package com.agnieszkaolive.training.jdbc;

import static com.agnieszkaolive.training.jdbc.StudentsDao.selectFromStudents;

public class StudentsDaoMain {

    public static void main(String[] args) {
        StudentsDao agaStudentsDao = new StudentsDao();
        Students agaStudents = new Students(43, "Jeremi", "Kundera", 4);
//        Students wiktorStudents = new Students(44, "Wiktor", "Kocerko", 5);
        Students krystianStudents = new Students(45, "Krystian", "Waliczek", 3);
//
//        agaStudentsDao.insertIntoStudents(agaStudents);
//        agaStudentsDao.insertIntoStudents(wiktorStudents);

        selectFromStudents();
        agaStudentsDao.insertIntoStudents(krystianStudents);
    }
}
