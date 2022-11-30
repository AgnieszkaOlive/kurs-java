package com.agnieszkaolive.training.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BookDao {
    private static final String SELECT_FROM_BOOKS = "SELECT * FROM BOOKS ORDER BY ID;";
    private static final String INSERT_INTO_BOOKS = "INSERT INTO BOOKS (ID , NAME , PRICE) VALUES (?, ?, ?);";
    private static final String DELETE_RECORD = "DELETE FROM BOOKS WHERE ID = ?";
    private static final String UPDATE_BOOKS = "UPDATE BOOKS SET PRICE = ? WHERE ID = ?;";
    //   private static final String UPDATE_BOOKS = "UPDATE BOOKS SET PRICE = ? WHERE ID = ?;";
    private static final String SELECT_ONE_RECORD = "SELECT ID , NAME , PRICE FROM BOOKS WHERE ID = ?;";

    public void deleteRecordFromBooks(int id) {
        System.out.println("deleteRecordFromBooks()");
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_RECORD);) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBooksPrice(Book book) {
        System.out.println("updateBooksPrice()");
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOKS);) {
            preparedStatement.setInt(1, book.getPrice());
            preparedStatement.setInt(2, book.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //    public void updateBooksPrice(Book book) {
//        System.out.println("updateBooksPrice()");
//        Connection connection = null;
//        String SELECT_ONE_RECORD = "SELECT ID , NAME , PRICE FROM BOOKS WHERE ID = 5 ";
//        try {
////            Statement statement = connection.createStatement();
////            statement.executeUpdate(UPDATE_BOOKS);
////            ResultSet resultSet = statement.executeQuery(SELECT_ONE_RECORD);
//            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
////            Statement statement = connection.createStatement();
////            statement.executeUpdate(UPDATE_BOOKS);
//            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOKS);
//            preparedStatement.setInt(1, book.getId());
//            preparedStatement.setString(2, book.getName());
//            preparedStatement.setInt(3, book.getPrice());
//            int execute = preparedStatement.executeUpdate();
//            System.out.println("Execute " + execute);
//
//            ResultSet resultSet = statement.executeQuery(SELECT_ONE_RECORD);
////            int c = resultSet.getInt()
//            //  ResultSet resultSet = statement.executeQuery(SELECT_ONE_RECORD);
//            //  resultSet.getInt();
//            while (resultSet.next()) {
//                int id = resultSet.getInt(1);
//                String name = resultSet.getString(2);
//                int price = resultSet.getInt(3);
//                // book = new Book(id, name, price);
//                System.out.println("Updated book : id " + id + " name " + name + " price " + price);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        // return book;
//    }
    public void insertIntoBooks(Book book) {
        System.out.println("insertIntoBooks(" + book + ")");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_BOOKS);
            preparedStatement.setInt(1, book.getId());
            preparedStatement.setString(2, book.getName());
            preparedStatement.setInt(3, book.getPrice());
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

    public void insertIntoBooksWithResources(Book book) {
        System.out.println("insertIntoBooksWithResources(" + book + ")");
        //Connection connection = null;
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_BOOKS);) {
            preparedStatement.setInt(1, book.getId());
            preparedStatement.setString(2, book.getName());
            preparedStatement.setInt(3, book.getPrice());
            int execute = preparedStatement.executeUpdate();
            System.out.println("Execute " + execute);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        finally {
//            try {
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
    }

    // TODO: 11/16/2022 zmodyfikowac metode selectFromBook tak aby zwracala liste ksiazek, nie tylko 1 ksiazke
    // zmodyfikowac blok finally zastepujac try with resource
    public static List<Book> selectFromBooks() {
        System.out.println("selectFromBooks()");
        // Connection connection = null;
        Book book;
        //idea
        // List<Book> myBooksList = null;
        List<Book> myBooksList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
             Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery(SELECT_FROM_BOOKS);
            System.out.println("ResultSet " + resultSet);
            // resultSet.next();
            //        int n = 0;
            //         for (int i = 0; i <= n; i++) {
            while (resultSet.next()) {
                //               n++;
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int price = resultSet.getInt(3);
                book = new Book(id, name, price);
                myBooksList.add(book);
            }
            //      }
//            while (resultSet.next()) {
//                int id = resultSet.getInt(1);
//                String name = resultSet.getString(2);
//                int price = resultSet.getInt(3);
//                book = new Book(id, name, price);

//                // myBooksList = new ArrayList<>();
//                // myBookList.add(book);
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //myBooksList.add(book);
        System.out.println("selectFromBooks() = " + myBooksList);
        return myBooksList;
    }

    public static void selectOneRecord(int id) {
        //chcialam stworzyc metode select ktora bedzie wybierala tylko jeden rekord z tabeli wg wskazanego przeze mnie nr ID
        // zapytanie "SELECT_ONE_RECORD" ma pytajnik, zeby go uzupelnic potrzenuje preparedStatement, ale do metody SELECT trzeba uzyc createStatement

        System.out.println("selectOneRecord()");
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            Statement statement  = connection.createStatement();){
            ResultSet resultSet = statement.executeQuery(SELECT_ONE_RECORD);
            id = resultSet.getInt(1);
//            preparedStatement.setInt(1, id);
//            preparedStatement.executeUpdate();
            System.out.println("The book to delete has ID number : " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


//    public static Book selectFromBooks() {
//        System.out.println("selectFromBooks()");
//
//        Connection connection = null;
//        Book book = null;
//        try {
//            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(SELECT_FROM_BOOKS);
//            System.out.println("ResultSet " + resultSet);
//
//            while (resultSet.next()) {
//                int id = resultSet.getInt(1);
//                String name = resultSet.getString(2);
//                int price = resultSet.getInt(3);
//                book = new Book(id, name, price);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println("selectFromBooks() = " + book);
//        return book;
//    }
    // TODO: 11/16/2022 dodac brakujace metody CRUD(update, delete)
}
