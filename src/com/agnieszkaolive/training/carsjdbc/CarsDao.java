package com.agnieszkaolive.training.carsjdbc;


import java.sql.*;

public class CarsDao {
    private static final String SELECT_FROM_CARS = "SELECT * FROM CARS ORDER BY ID;";

    public static void selectFromCars() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_FROM_CARS);
            System.out.println("ResultSet " + resultSet);

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                System.out.println("ID " + id);

                String brand = resultSet.getString("BRAND");
                System.out.println("BRAND " + brand);

                int speed = resultSet.getInt("SPEED");
                System.out.println("SPEED " + speed);

                int age = resultSet.getInt("AGE");
                System.out.println("AGE " + age);

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
