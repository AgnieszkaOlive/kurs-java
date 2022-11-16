package com.agnieszkaolive.training.jdbc;

import java.sql.*;

public class PeopleDao {

    private static final String INSERT_PEOPLE_SQL = "INSERT INTO PEOPLE ( ID , FIRST_NAME , LAST_NAME , GENDER , AGE )\n" +
            " VALUES(?, ?, ?, ?, ?);";
    private static final String SELECT_PEOPLE_SQL = "SELECT * FROM PEOPLE ORDER BY ID;";

    public void insertIntoPeople(People people) {
        System.out.println("insertIntoPeople(" + people + ")");
        Connection connection = null;
        //  Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PEOPLE_SQL);
            preparedStatement.setInt(1, people.getId());
            preparedStatement.setString(2, people.getFirstName());
            preparedStatement.setString(3, people.getSecondName());
            preparedStatement.setString(4, people.getGender());
            preparedStatement.setInt(5, people.getAge());
            // boolean execute = preparedStatement.execute();
            int execute = preparedStatement.executeUpdate();
            System.out.println("Execute on table people " + execute);
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
    public static void selectFromPeople() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_PEOPLE_SQL);
            System.out.println("Resultset " + resultSet);

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                System.out.println("ID " + id);

                String firstName = resultSet.getString("FIRST_NAME");
                System.out.println("First name " + firstName);

                String lastName = resultSet.getString("LAST_NAME");
                System.out.println("Last name " + lastName);
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

}
// TODO: 11/9/2022  stworzyc nowa tabele inna niz istniejace
//stworzyc nowa klase dao dla nowej tabeli
//w klasie dao stworzyc metode pobierajaca (select) dane i metode wstawiajaca (insert) jeden wiersz