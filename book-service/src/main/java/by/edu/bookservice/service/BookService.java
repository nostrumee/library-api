package by.edu.bookservice.service;

import by.edu.bookservice.dto.BookDTO;

import java.util.List;

public interface BookService {

    List<BookDTO> getAllBooks();

    BookDTO getById(String id);

    BookDTO getByISBN(String isbn);

    String createBook(BookDTO bookDTO);

    BookDTO borrowBook(String id);

    void returnBook(String id);

    BookDTO updateBook(BookDTO bookDTO, String id);

    void deleteBook(String id);

    List<BookDTO> getAvailableBooks();

}
