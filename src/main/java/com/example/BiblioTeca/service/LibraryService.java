package com.example.BiblioTeca.service;

import com.example.BiblioTeca.model.Book;
import com.example.BiblioTeca.model.Library;
import com.example.BiblioTeca.model.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    private LibraryRepository libraryRepository;
    private Library library;
    public LibraryService(LibraryRepository libraryRepository){
        this.libraryRepository = libraryRepository;
    }
    public List<Book> getAvailableBooks(){
        return libraryRepository.getAvailableBooks();
    }

    public void returnBook(Book book) {
        libraryRepository.returnBook(book);
    }

    public boolean checkoutBook(Book book){
        List<Book> libraryRepo= this.library.getCheckOutBookList();
        for(Book libraryBook : libraryRepo){
            if(libraryBook.getBookName().equalsIgnoreCase(book.getBookName())) {
                libraryRepo.remove(libraryBook);
                library.getCheckOutBookList().add(libraryBook);
                return true;
            }
        }
        return false;
    }

}
