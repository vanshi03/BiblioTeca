package com.example.BiblioTeca;

import com.example.BiblioTeca.model.Book;
import com.example.BiblioTeca.service.LibraryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class LibraryTest {

    @MockBean
    private LibraryService service;

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("When the library getAvailableBooks is called should return null if no book is available")
    public void checkIfAvailableRepositoryOfLibraryReturnedNullIfNoBooksAvailableInLibrary(){
        List<Book> libraryRepo = service.getAvailableBooks();
        assertEquals(new ArrayList<Book>(), libraryRepo);
    }

//package com.example.BiblioTeca;
//
//import com.example.BiblioTeca.model.Book;
//import com.example.BiblioTeca.service.LibraryService;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.hamcrest.Matchers.hasSize;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//
//@SpringBootTest
//class LibraryTest {
//
//    @MockBean
//    private LibraryService service;
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Test
//    @DisplayName("When the library getAvailableBooks is called should return null if no book is available")
//    public void checkIfAvailableRepositoryOfLibraryReturnedNullIfNoBooksAvailableInLibrary(){
//        List<Book> libraryRepo = service.getAvailableBooks();
//        assertEquals(new ArrayList<Book>(), libraryRepo);
//    }
//
//    @Test
//    @DisplayName("When the library getAvailableBooks is called should return the list of all books available")
//    public void checkIfAvailableRepositoryOfLibraryReturned() throws Exception{
//        Book book1 = new Book("Harry Potter");
//        Book book2 = new Book("Let us C");
//
//        List<Book> testRepo = new ArrayList<>();
//        testRepo.add(book1);
//        testRepo.add(book2);
//
//        when(service.getAvailableBooks()).thenReturn(testRepo);
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/viewBookList")
//                .contentType(MediaType.APPLICATION_JSON)
//        ).andExpect(jsonPath("$", hasSize(1))).andDo(print());
//    }
//        @Test
//    @DisplayName("When the library checkOutBook is called should return true if Checkout is successful")
//    public void checkIfBookIsCheckedOut() throws Exception{
//        Book book = new Book("Let us C", "Yashavant Kanetkar", 2004);
//        //ObjectMapper objectMapper = new ObjectMapper();
//        when(libraryService.checkoutBook(book)).thenReturn(true);
//        mockMvc.perform(MockMvcRequestBuilders.post("/viewCheckOutBookList")
//                .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"bookName\":\"Let us C\",\"author\":\"Yashavant Kanetkar\",\"publicationYear\":2004}"))
////                        .content(objectMapper.writeValueAsString(book)))
//                .andExpect(status().isOk());
//
//
////                        .accept(MediaType.APPLICATION_JSON))
////                .andExpect(status().isCreated())
////                .andExpect(content().contentType(MediaType.))
////                                .json("{'data':[{'useRegEx':'false','hosts':'v2v2v2'}]}")));
//
//
//    }
}
//        ).andExpect(jsonPath("$", hasSize(2))).andDo(print());
//    }
//
//}