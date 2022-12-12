package com.agnieszkaolive.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcMain2 {
//    private static final String INSERT_PEOPLE_SQL2 = "INSERT INTO PEOPLE (People people);";
   // private static final People people1 = new People(8, "Milena", "Ptaszynska", "female", 34);
    private static People people;


    public static void main(String[] args) {
        People people = new People(8, "Milena", "Ptaszynska", "female", 34);

       // peopleTable3(people);

    }


//    public static void peopleTable3 (People people){
//        try {
//            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
//            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PEOPLE_SQL2);
//            preparedStatement.setObject(8, people);
//            boolean execute = preparedStatement.execute();
//            System.out.println("Execute on table people " + execute);
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//    }
}
