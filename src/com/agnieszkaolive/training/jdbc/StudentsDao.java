package com.agnieszkaolive.training.jdbc;

import java.sql.*;

public class StudentsDao {

    private static final String SELECT_FROM_STUDENTS = "SELECT * FROM STUDENTS  ORDER BY ID;";
    private static final String INSERT_INTO_STUDENTS = "INSERT INTO STUDENTS ( ID , NAME , LAST_NAME , NOTE) VALUES(?, ?, ?, ?);";

    public static void selectFromStudents() {
        Connection connection = null;
        try {
            // Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_FROM_STUDENTS);
            System.out.println("resultSet : " + resultSet);

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                System.out.println("ID : " + id);

                String name = resultSet.getString("NAME");
                System.out.println("Name : " + name);

                String lastName = resultSet.getString("LAST_NAME");
                System.out.println("Last name : " + lastName);

                int note = resultSet.getInt("NOTE");
                System.out.println("Note : " + note);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void insertIntoStudents(Students students) {
        System.out.println("insertIntoStudents(" + students +")");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_STUDENTS);
            preparedStatement.setInt(1, students.getId());
            preparedStatement.setString(2, students.getName());
            preparedStatement.setString(3, students.getLastName());
            preparedStatement.setInt(4, students.getNote());
            // boolean execute = preparedStatement.execute();
            int execute = preparedStatement.executeUpdate();
            System.out.println("Execute " + execute);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
