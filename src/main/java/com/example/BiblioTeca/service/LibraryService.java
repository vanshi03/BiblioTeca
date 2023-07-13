package com.example.BiblioTeca.service;

import com.example.BiblioTeca.model.Book;
import com.example.BiblioTeca.model.LibraryRepository;
import com.example.BiblioTeca.model.User;
import com.example.BiblioTeca.model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class LibraryService {

    private LibraryRepository libraryRepository;
    public LibraryService(LibraryRepository libraryRepository){
        this.libraryRepository = libraryRepository;
    }
    public List<Book> getAvailableBooks(){
        return libraryRepository.getAvailableBooks();
    }
    public List<Movie> getAvailableMovies(){
        return libraryRepository.getAvailableMovies();
    }

    public boolean returnBook(Book book){
        if(libraryRepository.getIssuedBooks().containsKey(book)){
            libraryRepository.getIssuedBooks().remove(book);
            libraryRepository.getAvailableBooks().add(book);
            return true;
        }
        return false;
    }

    public boolean checkoutBook(Book book, User user){
        if(libraryRepository.getAvailableBooks().contains(book)){
            libraryRepository.getAvailableBooks().remove(book);
            libraryRepository.getIssuedBooks().put(book, user);
            return true;
        }
        return false;
    }
    public boolean checkoutMovie(Movie movie){
        if(libraryRepository.getAvailableMovies().contains(movie)){
            libraryRepository.getAvailableMovies().remove(movie);
            libraryRepository.getIssuedMovies().add(movie);
            return true;
        }
        return false;
    }

    public List<Book> getCheckoutListOfUser(User user) {
        Map<Book, User> issuedBooks = libraryRepository.getIssuedBooks();
        List<Book> issueBooksOfUser = new ArrayList<>();
        for(Map.Entry<Book, User> entry : issuedBooks.entrySet()){
            if(entry.getValue().equals(user)){
                issueBooksOfUser.add(entry.getKey());
            }
        }
        return issueBooksOfUser;
    }
}
