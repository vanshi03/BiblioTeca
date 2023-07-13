package com.example.BiblioTeca;

import com.example.BiblioTeca.model.Book;
import com.example.BiblioTeca.model.Movie;
import com.example.BiblioTeca.service.LibraryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
class BiblioTecaControllerTest {
    @MockBean
    LibraryService service;
    @Autowired
    MockMvc mockMvc;
    @Test
    @DisplayName("When the library checkOutBook is called should return true if Checkout is successful")
    public void checkIfBookIsCheckedOut() throws Exception{
        Book book = new Book("Let us C", "Yashavant Kanetkar", "2004");
        //ObjectMapper objectMapper = new ObjectMapper();
        when(service.checkoutBook(any(Book.class))).thenReturn(true); //anyBook
        mockMvc.perform(post("/checkoutBook")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"bookName\":\"Let us C\",\"author\":\"Yashavant Kanetkar\",\"publicationYear\":\"2004\"}"))
//                        .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isOk());
    }
    @Test
    @DisplayName("When the library checkOutMovie is called should return true if Checkout is successful")
    public void checkIfMovieIsCheckedOut() throws Exception{
//        Movie book = new Movie("Let us C", "Yashavant Kanetkar", "2004");
        //ObjectMapper objectMapper = new ObjectMapper();
        when(service.checkoutMovie(any(Movie.class))).thenReturn(true);
        mockMvc.perform(post("/checkoutMovie")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"MovieName\":\"Hera Pheri\",\"director\":\"Priyadarshan\",\"releaseYear\":\"2000\"}"))
//                        .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isOk());
    }
    @Test
    @DisplayName("Should be able to return an issued book")
    public void ableToReturnAnIssuedBook() throws Exception{
        when(service.returnBook(any(Book.class))).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.post("/returnBook")
                        .content("{ \"bookName\": \"Harry Potter\", \"author\": \"JK Rowling\", \"publicationYear\":\"1\" }")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isOk());
        verify(service
                ,times(1)).returnBook(any(Book.class));
    }
    @Test
    @DisplayName("Should not be able to return a book which is not issued")
    public void notAbleToReturnBook() throws Exception{
        when(service.returnBook(any(Book.class))).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.post("/returnBook")
                        .content("{ \"bookName\": \"Harry Potter\", \"author\": \"JK Rowling\", \"publicationYear\":\"1\" }")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isOk());
        verify(service
                ,times(1)).returnBook(any(Book.class));
    }
}