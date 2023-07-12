package com.example.BiblioTeca.service;

import com.example.BiblioTeca.model.Book;
import com.example.BiblioTeca.model.Library;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    private Library library;
    public LibraryService(Library library){
        this.library = library;
    }
    public List<Book> getAvailableBooks(){
        return library.getRepository();
    }

    public boolean addBook(Book book){
        return library.addBookToRepository(book);
    }

}
