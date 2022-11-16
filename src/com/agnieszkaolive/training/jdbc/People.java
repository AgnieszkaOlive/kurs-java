package com.agnieszkaolive.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class People {
    private int id;
    private String firstName;
    private String secondName;
    private String gender;
    private int age;
    //private static final String INSERT_PEOPLE_SQL2 = "INSERT INTO PEOPLE ( ID , FIRST_NAME , LAST_NAME , GENDER , AGE )\n" +
     //       " VALUES(?, ?, ?, ?, ?);";

    public People() {
    }

    public People(int id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public People(int id, String firstName, String secondName, String gender, int age) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.gender = gender;
        this.age = age;
    }


//    public static void addPeopleToTable(int id, String firstName, String lastName, String gender, int age) {
//        try {
//            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
//            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PEOPLE_SQL2);
//            preparedStatement.setInt(1, id);
//            preparedStatement.setString(2, firstName);
//            preparedStatement.setString(3, lastName);
//            preparedStatement.setString(4, gender);
//            preparedStatement.setInt(5, age);
//            boolean execute = preparedStatement.execute();
//            System.out.println("Execute on table people " + execute);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
