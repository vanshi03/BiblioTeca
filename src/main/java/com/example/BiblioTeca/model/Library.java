package com.example.BiblioTeca.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Library {

    private List<Book> repository;
    private List<Book> checkOutBookList;
//    private List<Book> issuedBooks;

    public Library() {
        this.repository = new ArrayList<>();
        this.checkOutBookList = new ArrayList<Book>();
        this.repository.add(new Book("Harry Potter", "JK Rowling"));
        this.repository.add(new Book("Let us C", "Yashavant Kanetkar", 2004));
        this.checkOutBookList.add(new Book("Let us C", "Yashavant Kanetkar", 2004));
        this.checkOutBookList.add(new Book("Harry Potter", "JK Rowling") );
//        this.repository.add(new Book("Harry Potter", "JK Rowling"));
//        this.repository.add(new Book("Let us C", "Yashavant Kanetkar", 2004));
    }

    public List<Book> getRepository() {
        return this.repository;
    }

    public List<Book> getCheckOutBookList() {
        return checkOutBookList;
    }
    public boolean setCheckOutBookList(Book book) {

        return checkOutBookList.add(book);
    }

    public boolean addBookToRepository(Book book) {
        return this.repository.add(book);
    }

    public List<Book> getIssuedBooks() {
        return checkOutBookList;
    }

    public void setIssuedBooks(Book book) {
        this.checkOutBookList.add(book);
    }
}
