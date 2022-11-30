package com.agnieszkaolive.training.jdbc;


import java.util.List;

public class BooksDaoMain {
    public static void main(String[] args) {

        // Book starowislnaBook = new Book(3, "Ender's Game", 45);
        // BookDao agaBookDao = new BookDao();
        //agaBookDao.insertIntoBooks(starowislnaBook);

//        Book karmelickaBook = new Book(2, "Alice in Neverland", 52);
//        BookDao aliceBookDao = new BookDao();
//        aliceBookDao.insertIntoBooks(karmelickaBook);

        Book brackaBook = new Book(5, "Doctor Dolittle", 32);
//        BookDao dolittleBookDao = new BookDao();
//        dolittleBookDao.insertIntoBooksWithResources(brackaBook);

        // Book guillaumeBook = BookDao.selectFromBooks();
//        guillaumeBooksList.selectFromBooks();
//        System.out.println("guillaumeBooksList " + guillaumeBooksList);
        BookDao.selectFromBooks();
      //  aliceBookDao.deleteRecordFromBooks();

//        BookDao updateBook = new BookDao();
//        updateBook.updateBooksPrice();
//        updateBook.deleteRecordFromBooks();

        // BookDao guillaumeBook = new BookDao();
       // BookDao.selectFromBooks();

    }
}
//org.h2.jdbc.JdbcSQLNonTransientException: Method is only allowed for a query. Use execute or executeUpdate instead of executeQuery; SQL statement:
//UPDATE BOOKS SET PRICE = '1000' WHERE ID = '5' [90002-214]