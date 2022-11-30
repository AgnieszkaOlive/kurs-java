package com.agnieszkaolive.training.jdbc;

import java.sql.*;

public class AnimalDao {
    private static final String CREATE_ANIMALS = "CREATE TABLE ANIMALS (ID INTEGER, name VARCHAR(255), WEIGHT INTEGER);";
    private static final String INSERT_INTO_ANIMALS = "INSERT INTO ANIMALS (ID , NAME , WEIGHT) VALUES (?, ?, ?);";
    private static final String SELECT_FROM_ANIMALS = "SELECT * FROM ANIMALS ORDER BY ID;";


    public static void createAnimals() {
        System.out.println("createAnimals()");
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
             Statement statement = connection.createStatement();) {
            statement.executeUpdate(CREATE_ANIMALS);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertIntoAnimals(Animal animal) {
        System.out.println("insertIntoAnimal()");
        //Animal animal = null = czemu tu to wyrzuci wyjatek nullPointerException
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_ANIMALS)) {
            preparedStatement.setInt(1, animal.getID());
            preparedStatement.setString(2, animal.getName());
            preparedStatement.setInt(3, animal.getWeight());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        public static void selectFromAnimals(){
            System.out.println("selectFromAnimals()");
            try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
                 Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(SELECT_FROM_ANIMALS);
            } catch (SQLException e){
                e.printStackTrace();

        }
    }


}