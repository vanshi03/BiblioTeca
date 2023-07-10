package com.example.BiblioTeca;

import com.example.model.Book;
import com.example.service.LibraryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LibraryTest {

    LibraryService service = new LibraryService();

    @Test
    @DisplayName("When the library getAvailableBooks is called should return null if no book is available")
    public void checkIfAvailableRepositoryOfLibraryReturnedNullIfNoBooksAvailableInLibrary(){
        List<Book> libraryRepo = service.getAvailableBooks();
        assertEquals(new ArrayList<Book>(), libraryRepo);
    }

    @Test
    @DisplayName("When the library getAvailableBooks is called should return the list of all books available")
    public void checkIfAvailableRepositoryOfLibraryReturned(){
        Book book1 = new Book("Harry Potter");
        Book book2 = new Book("Let us C");

        service.addBook(book1);
        service.addBook(book2);
        List<Book> testRepo = new ArrayList<>();
        testRepo.add(book1);
        testRepo.add(book2);
        List<Book> libraryRepo = service.getAvailableBooks();
        assertEquals(testRepo, libraryRepo);
    }

}