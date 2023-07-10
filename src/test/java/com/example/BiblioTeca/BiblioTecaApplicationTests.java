package com.example.BiblioTeca;

import com.example.model.Book;
import com.example.service.LibraryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BiblioTecaApplicationTests {

	LibraryService service = new LibraryService();

	@Test
	@DisplayName("When the library getAvailableBooks is called should return null if no book is available")
	public void checkIfAvailableRepositoryOfLibraryReturnedNullIfNoBooksAvailableInLibrary(){
		List<Book> libraryRepo = service.getAvailableBooks();
		assertEquals(new ArrayList<Book>(), libraryRepo);
	}

	@Test
	void contextLoads() {
	}

}
