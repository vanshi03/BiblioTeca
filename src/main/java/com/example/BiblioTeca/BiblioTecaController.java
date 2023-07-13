package com.example.BiblioTeca;

import com.example.BiblioTeca.model.Book;
import com.example.BiblioTeca.model.User;
import com.example.BiblioTeca.model.Movie;
import com.example.BiblioTeca.service.LibraryService;
import com.example.BiblioTeca.wrapper.IssueRequestWrapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String getBooks() {
        List<Book> libraryRepository = service.getAvailableBooks();
        if(libraryRepository.size() == 0) {
            return "There are no books available in the Library to display";
        }
        else{
            return libraryRepository.toString();
        }
    }
    @RequestMapping("/movies")
    public String getMovies() {
        List<Movie> libraryRepository = service.getAvailableMovies();
        if(libraryRepository.size() == 0) {
            return "There are no Movies available in the Library to display";
        }
        else{
            return libraryRepository.toString();
        }
    }
    @PostMapping("/returnBook")
    public boolean returnBook(@RequestBody Book book){
        return service.returnBook(book);
        //ResponseEntity.ok().build();

    }

    @PostMapping("/checkoutBook")
    public boolean checkoutBook(@RequestBody IssueRequestWrapper issueRequest) {
        return service.checkoutBook(issueRequest.getBook(), issueRequest.getUser());
    }

    @PostMapping("/checkedoutBooksOfUser")
    public List<Book> viewCheckedOutBookList(@RequestBody User user) {
        return service.getCheckoutListOfUser(user);
    }
    @PostMapping("/checkoutMovie")
//    @GetMapping(value = "/stringToJson", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean viewCheckOutMovieList(@RequestBody Movie movie) {
        return service.checkoutMovie(movie);
    }
}
