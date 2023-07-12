package com.example.BiblioTeca.model;

import org.springframework.stereotype.Component;

public class Book{
    private String bookName = "";
    private String author = "";
    private int publicationYear = 0;

    public Book(String bookName) {
        this.bookName = bookName;
    }
    public Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }
    public Book(String bookName, int publicationYear) {
        this.bookName = bookName;
        this.publicationYear = publicationYear;
    }
    public Book(String bookName, String author, int publicationYear) {
        this.bookName = bookName;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    @Override
    public String toString() {
        return bookName + '\n';
    }
}
