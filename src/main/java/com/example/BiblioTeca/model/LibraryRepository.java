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

        this.availableBooks.add(new Book("Harry Potter", "JK Rowling"));
        this.availableBooks.add(new Book("Let us C", "Yashavant Kanetkar", 2004));
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

    public void setIssuedBooks(Book book) {
        this.issuedBooks.add(book);
        this.availableBooks.remove(book);
    }
    public boolean returnBook(Book book){
        boolean isRemoved = this.issuedBooks.remove(book);
        if(isRemoved) {
            this.availableBooks.add(book);
            return true;
        }
        return false;
    }
}
