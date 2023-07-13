package com.example.BiblioTeca.service;

import com.example.BiblioTeca.model.Book;
import com.example.BiblioTeca.model.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    private LibraryRepository libraryRepository;
    public LibraryService(LibraryRepository libraryRepository){
        this.libraryRepository = libraryRepository;
    }
    public List<Book> getAvailableBooks(){
        return libraryRepository.getAvailableBooks();
    }

    public boolean returnBook(Book book){
        if(libraryRepository.getIssuedBooks().contains(book)){
            libraryRepository.getIssuedBooks().remove(book);
            libraryRepository.getAvailableBooks().add(book);
            return true;
        }
        return false;
    }

    public boolean checkoutBook(Book book){
        if(libraryRepository.getAvailableBooks().contains(book)){
            libraryRepository.getAvailableBooks().remove(book);
            libraryRepository.getIssuedBooks().add(book);
            return true;
        }
        return false;
    }

}
