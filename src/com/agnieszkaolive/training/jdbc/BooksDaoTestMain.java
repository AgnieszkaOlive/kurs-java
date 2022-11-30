package com.agnieszkaolive.training.jdbc;

import java.util.List;

public class BooksDaoTestMain {
    public static void main(String[] args) {
        List<Book> books = BookDao.selectFromBooks();
        System.out.println("ilosc dostepnych ksiazek " + books.size());
        //wywolanie metody usuwajacej
        BookDao bookDao = new BookDao();
        bookDao.deleteRecordFromBooks(3);
        //wywolanie metody pobierajcej wszystkie ksiazki
        List<Book> booksAfterDelete = BookDao.selectFromBooks();
        //wyswietlenie ilosci ksiazek
        System.out.println("ilosc dostepnych ksiazek " + booksAfterDelete.size());

        Book updateBook = new Book(5, "Doctor Dollitle", 1); // czy to nie problem, że tworze "nowa" book, która juz istnieje?
        //wywolywanie metody aktualizujacej
        bookDao.updateBooksPrice(updateBook);
        //wywolanie metody pobierajcej wszystkie ksiazki
        List<Book> booksAfterUpdating = BookDao.selectFromBooks();

    }
}
// TODO: 11/24/2022 analogicznie do weryfikacji usuwania ksiazki sprawdzic aktualizowanie ksiazki
// stworzyc nowa tabele oraz dao dla tej tabeli w ktorym umiescic metody CRUD