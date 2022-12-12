package com.agnieszkaolive.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcMain3 {
    private static final String INSERT_PRODUCTS2_SQL = "INSERT INTO PRODUCTS2 (ID, NAME, BRAND, PRICE, DISCOUNT) \n" +
            " VALUES (?, ?, ?, ?, ?);";
    //private static final String INSERT_PEOPLE_SQL2 = "INSERT INTO PEOPLE ( ID , FIRST_NAME , LAST_NAME , GENDER , AGE )\n" +
     //       " VALUES(?, ?, ?, ?, ?);";


    public static void main(String[] args) {
        addToProducts2Table(2, "CHOCOLATE", "LINDT", 7, 1);

    }

    public static void addToProducts2Table(int id, String name, String brand, int price, int discount){
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCTS2_SQL);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, brand);
            preparedStatement.setInt(4, price);
            preparedStatement.setInt(5, discount);
            boolean execute = preparedStatement.execute();
            System.out.println("Execute on products2 " + execute);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
