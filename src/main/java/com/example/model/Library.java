package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> repository;

    public Library() {
        this.repository = new ArrayList<>();
    }

    public List<Book> getRepository() {
        return this.repository;
    }

    public boolean addBookToRepository(Book book) {
        return this.repository.add(book);
    }
}
