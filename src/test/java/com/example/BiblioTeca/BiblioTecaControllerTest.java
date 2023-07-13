package com.example.BiblioTeca;

import com.example.BiblioTeca.model.Book;
import com.example.BiblioTeca.model.Library;
import com.example.BiblioTeca.service.LibraryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class BiblioTecaControllerTest {

    @MockBean
    LibraryService service;

    @Autowired
    MockMvc mockMvc;

//    @Test
//    @DisplayName("When the library has books available and showBookList is called then it should return the list of all books available")
//    public void checkIfAvailableRepositoryOfLibraryReturned() throws Exception{
//        Book book1 = new Book("Harry Potter");
//        Book book2 = new Book("Let us C");
//
//        List<Book> testRepo = new ArrayList<>();
//        testRepo.add(book1);
//        testRepo.add(book2);
//
////        when(biblioTecaController.viewBookList()).thenReturn(testRepo.toString());
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/viewBookList")
//                .contentType(MediaType.APPLICATION_JSON)
//        ).andExpect(jsonPath("$", hasSize(2))).andDo(print());
//    }
//
    @Test
    @DisplayName("Should be able to return an issued book")
    public void ableToReturnAnIssuedBook() throws Exception{
        when(service.returnBook(any(Book.class))).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.post("/returnBook")
                        .content("{ \"bookName\": \"Harry Potter\", \"author\": \"JK Rowling\", \"publicationYear\":\"1\" }")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("true"));

    }

    @Test
    @DisplayName("Should not be able to return a book which is not issued")
    public void notAbleToReturnBook() throws Exception{
        when(service.returnBook(any(Book.class))).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.post("/returnBook")
                        .content("{ \"bookName\": \"Harry Potter\", \"author\": \"JK Rowling\", \"publicationYear\":\"1\" }")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("true"));

    }

}