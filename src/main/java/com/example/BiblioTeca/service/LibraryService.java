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

    public boolean returnBook(Book book) {

        List<Book> issuedBook = library.getIssuedBooks();
        for(int i=0; i<issuedBook.size(); i++){
            if(issuedBook.get(i).getBookName().equalsIgnoreCase(book.getBookName())){
                issuedBook.remove(book);
                library.getRepository().add(book);
                return false;
            }
        }
        return true;
    }

}
