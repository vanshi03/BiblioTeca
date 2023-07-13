package com.example.BiblioTeca;

import com.example.BiblioTeca.model.Book;
import com.example.BiblioTeca.service.LibraryService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
            String bookList = "";
            for(Book book : libraryRepository){
                bookList += "<H2>"+book.getBookName()+"</H2>";
                if(book.getAuthor().equals("")){
                    bookList += "<P>Author unknown</P>";
                }
                else {
                    bookList += "<P>"+book.getAuthor()+"</P>";
                }

                if(book.getPublicationYear() == 0){
                    bookList += "<P>Unknown publication year</P>";
                }
                else {
                    bookList += "<P>"+book.getPublicationYear()+"</P>";
                }
                bookList += "<BR/>";
            }
            return bookList;
        }
    }
    @PostMapping("/returnBook")
    public boolean returnBook(@RequestBody Book book){
        return service.returnBook(book);
        //ResponseEntity.ok().build();

    }

    @PostMapping("/viewCheckOutBook")
    @GetMapping(value = "/stringToJson", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean viewCheckOutBookList(@RequestBody Book book) {
        return service.checkoutBook(book);
    }
}
