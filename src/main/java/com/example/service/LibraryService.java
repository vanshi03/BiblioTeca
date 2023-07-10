package com.example.service;

import com.example.model.Book;
import com.example.model.Library;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    Library library = new Library();
    public List<Book> getAvailableBooks(){
        return library.getRepository();
    }

    public boolean addBook(Book book){
       return library.addBookToRepository(book);
    }

}
