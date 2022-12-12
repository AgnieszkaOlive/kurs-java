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
// TODO: 11/30/2022 dla klas JDBC main (czerwone) zrobic nowy branch
// dodac nowe pliki na branch (git add)
// zrobic commit nowych plikow
// zrobic push dla powyzszego commit
// na gitHub zrobic pull request
// na github zrobic merge
// w Intellj pobrac zmiany z github i zrobic porzadek z branchami
