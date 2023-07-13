package com.example.BiblioTeca.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LibraryRepository {

    private List<Book> availableBooks;
    private List<Movie> availableMovies;
    private List<Book> issuedBooks;
    private List<Movie> issuedMovies;

    public LibraryRepository() {
        this.availableBooks = new ArrayList<>();
        this.issuedBooks = new ArrayList<>();
        this.availableMovies = new ArrayList<>();
        this.availableMovies.add(new Movie("Hera Pheri","Priyadarshan","2000"));
        this.issuedMovies.add(new Movie("Hera Pheri","Priyadarshan","2000"));
        this.issuedBooks.add(new Book("Java book", "Java Rowling", "1997"));
        this.availableBooks.add(new Book("Harry Potter", "JK Rowling", null));
        this.availableBooks.add(new Book("Let us C", "Yashavant Kanetkar", "2004"));
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

    public List<Book> getIssuedBooks() {
        return issuedBooks;
    }
    public List<Movie> getIssuedMovies() {
        return issuedMovies;
    }
}
