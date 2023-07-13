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

    public boolean returnBook(Book book) {
        return libraryRepository.returnBook(book);
    }

    public boolean checkoutBook(Book book){
        List<Book> libraryRepo= this.libraryRepository.getIssuedBooks();
        for(Book libraryBook : libraryRepo){
            if(libraryBook.getBookName().equalsIgnoreCase(book.getBookName())) {
                libraryRepo.remove(libraryBook);
                libraryRepository.getIssuedBooks().add(libraryBook);
                return true;
            }
        }
        return false;
    }

}
