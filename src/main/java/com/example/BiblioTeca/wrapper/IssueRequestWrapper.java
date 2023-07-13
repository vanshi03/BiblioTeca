package com.example.BiblioTeca.wrapper;

import com.example.BiblioTeca.model.Book;
import com.example.BiblioTeca.model.User;

public class IssueRequestWrapper {
    private Book book;
    private User user;

    public IssueRequestWrapper() {
    }

    public IssueRequestWrapper(Book book, User user) {
        this.book = book;
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }
}
