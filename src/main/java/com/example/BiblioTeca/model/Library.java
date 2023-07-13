package com.example.BiblioTeca.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Library {

    private List<Book> repository;
    private List<Book> issuedBooks;

    public Library() {
        this.repository = new ArrayList<>();
        this.issuedBooks = new ArrayList<>();
        this.issuedBooks.add(new Book("Harry Potter", "JK Rowling") );
//        this.repository.add(new Book("Harry Potter", "JK Rowling"));
//        this.repository.add(new Book("Let us C", "Yashavant Kanetkar", 2004));
    }

    public List<Book> getRepository() {
        return this.repository;
    }

    public boolean addBookToRepository(Book book) {
        return this.repository.add(book);
    }

    public List<Book> getIssuedBooks() {
        return issuedBooks;
    }

    public void setIssuedBooks(Book book) {
        this.issuedBooks.add(book);
    }
}
