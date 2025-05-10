package com.example.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.entities.Book;

public class LibraryDB {

    private static Map<Integer, Book> books = new HashMap<>();
    private static int nextId = 1;

    static {
        books.put(nextId++, new Book("Clean Code", "Robert Martin"));
    }

    public static List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public static void addBook(Book book) {
        book.setId(nextId++);
        books.put(book.getId(), book);
    }

    public static void deleteBook(int id) {
        books.remove(id);
    }
}
