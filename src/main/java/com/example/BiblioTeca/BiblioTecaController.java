package com.example.BiblioTeca;

import com.example.BiblioTeca.model.Book;
import com.example.BiblioTeca.service.LibraryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/viewBookList")
    public String viewBookList() {
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

}
