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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class BiblioTecaControllerTest {

    @MockBean
    LibraryService libraryService;
    LibraryService service;

    @Autowired
    MockMvc mockMvc;

<<<<<<< HEAD
=======

>>>>>>> 1755977 ([Anjali,Vanshi]Added Checkout functionality)
//    @Test
//    @DisplayName("When the library has books available and showBookList is called then it should return the list of all books available")
//    public void checkIfAvailableRepositoryOfLibraryReturned() throws Exception{
//        Book book1 = new Book("Harry Potter");
//        Book book2 = new Book("Let us C");
//
//        List<Book> testRepo = new ArrayList<>();
//        testRepo.add(book1);
//        testRepo.add(book2);
<<<<<<< HEAD
//
////        when(biblioTecaController.viewBookList()).thenReturn(testRepo.toString());
=======
//        when(libraryService.getAvailableBooks()).thenReturn(testRepo);
>>>>>>> 1755977 ([Anjali,Vanshi]Added Checkout functionality)
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/viewBookList")
//                .contentType(MediaType.APPLICATION_JSON)
//        ).andExpect(jsonPath("$", hasSize(2))).andDo(print());
<<<<<<< HEAD
//    }
//
//    }
    @Test
    @DisplayName("When the library checkOutBook is called should return true if Checkout is successful")
    public void checkIfBookIsCheckedOut() throws Exception{
        Book book = new Book("Let us C", "Yashavant Kanetkar", 2004);
        //ObjectMapper objectMapper = new ObjectMapper();
        when(service.checkoutBook(any(Book.class))).thenReturn(true); //anyBook

        mockMvc.perform(post("/viewCheckOutBook")
                .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"bookName\":\"Let us C\",\"author\":\"Yashavant Kanetkar\",\"publicationYear\":2004}"))
//                        .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isOk());




//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated())
//                .andExpect(content().contentType(MediaType.))
//                                .json("{'data':[{'useRegEx':'false','hosts':'v2v2v2'}]}")));


    }
    @Test
    @DisplayName("Should be able to return an issued book")
    public void ableToReturnAnIssuedBook() throws Exception{
        doNothing().when(service).returnBook(any(Book.class));

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
        doNothing().when(service).returnBook(any(Book.class));

        mockMvc.perform(MockMvcRequestBuilders.post("/returnBook")
                        .content("{ \"bookName\": \"Harry Potter\", \"author\": \"JK Rowling\", \"publicationYear\":\"1\" }")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isOk());
        verify(service
                ,times(1)).returnBook(any(Book.class));

    }

}