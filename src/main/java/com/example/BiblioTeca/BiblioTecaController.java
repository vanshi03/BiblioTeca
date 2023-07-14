package com.example.BiblioTeca;

import com.example.BiblioTeca.exceptions.BadRequestException;
import com.example.BiblioTeca.model.Book;
import com.example.BiblioTeca.model.User;
import com.example.BiblioTeca.model.Movie;
import com.example.BiblioTeca.service.LibraryService;
import com.example.BiblioTeca.wrapper.IssueRequestWrapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class BiblioTecaController {
    private LibraryService service;

    public BiblioTecaController(LibraryService service) {
        this.service = service;
    }

    @RequestMapping("/")
    public String homePage(){
        return "Welcome to the Biblioteca Library";
    }

    @RequestMapping("/books")
    public List<Book> getBooks() throws BadRequestException{
        List<Book> libraryRepository = service.getAvailableBooks();
        if(libraryRepository.size() == 0) {
            throw new BadRequestException("There are no books available in the Library to display");
        }
        else{
            return libraryRepository;
        }
    }
    @RequestMapping("/movies")
    public List<Movie> getMovies() throws BadRequestException{
        List<Movie> libraryRepository = service.getAvailableMovies();
        if(libraryRepository.size() == 0) {
            throw new BadRequestException("There are no Movies available in the Library to display");
        }
        else{
            return libraryRepository;
        }
    }
    @PostMapping("/returnBook")
    public boolean returnBook(@RequestBody Book book){
        return service.returnBook(book);
    }

    @PostMapping("/checkoutBook")
    public boolean checkoutBook(@RequestBody IssueRequestWrapper issueRequest) {
        return service.checkoutBook(issueRequest.getBook(), issueRequest.getUser());
    }

    @GetMapping("/checkedoutBooksOfUser")
    public List<Book> viewCheckedOutBookList(@RequestBody User user) {
        return service.getCheckoutListOfUser(user);
    }
    @PostMapping("/checkoutMovie")
    public boolean viewCheckOutMovieList(@RequestBody Movie movie) throws BadRequestException{
        return service.checkoutMovie(movie);
    }

    @GetMapping("/userInformation")
    public User viewUser(@RequestBody String userId) {
        return service.getUserInformation(userId);
    }


}
