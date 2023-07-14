package com.example.BiblioTeca.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class LibraryRepository {

    private List<Book> availableBooks;
    private Map<Book, User> issuedBooks;
    private List<Movie> availableMovies;
    private List<Movie> issuedMovies;

    public LibraryRepository() {
        this.availableBooks = new ArrayList<>();
        this.availableMovies = new ArrayList<>();
        this.issuedBooks = new HashMap<>();
        this.issuedMovies = new ArrayList<>();

        this.availableBooks.add(new Book("Let us C", "Yashavant Kanetkar", "2004"));
        this.issuedBooks.put(new Book("Java book", "Java Rowling", "1997"), new User("1", "Saurabh"));
        this.issuedBooks.put(new Book("Java book", "Java Rowling", "1997"), new User("2", "Anjali"));
        this.availableBooks.add(new Book("Harry Potter", "JK Rowling", null));

        this.availableMovies.add(new Movie("Hera Pheri","Priyadarshan","2000"));
        this.issuedMovies.add(new Movie("Hera Pheri","Priyadarshan","2000"));

    }

    public List<Book> getAvailableBooks() {
        return this.availableBooks;
    }
    public List<Movie> getAvailableMovies(){ return this.availableMovies;}

    public boolean addBookToRepository(Book book) {
        return this.availableBooks.add(book);
    }
    public boolean addMovieToRepository(Movie movie) {
        return this.availableMovies.add(movie);
    }

    public Map<Book, User> getIssuedBooks() {
        return issuedBooks;
    }
    public List<Movie> getIssuedMovies() {
        return issuedMovies;
    }
}
