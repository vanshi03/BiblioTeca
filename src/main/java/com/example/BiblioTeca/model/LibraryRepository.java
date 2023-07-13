package com.example.BiblioTeca.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LibraryRepository {

    private List<Book> availableBooks;
    private List<Book> issuedBooks;

    public LibraryRepository() {
        this.availableBooks = new ArrayList<>();
        this.issuedBooks = new ArrayList<>();
        this.issuedBooks.add(new Book("Java book", "Java Rowling", "1997"));
        this.availableBooks.add(new Book("Harry Potter", "JK Rowling", null));
        this.availableBooks.add(new Book("Let us C", "Yashavant Kanetkar", "2004"));
    }

    public List<Book> getAvailableBooks() {
        return this.availableBooks;
    }

    public boolean addBookToRepository(Book book) {
        return this.availableBooks.add(book);
    }

    public List<Book> getIssuedBooks() {
        return issuedBooks;
    }
}
