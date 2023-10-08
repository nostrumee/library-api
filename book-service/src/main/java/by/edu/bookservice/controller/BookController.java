package by.edu.bookservice.controller;

import by.edu.bookservice.dto.BookDTO;
import by.edu.bookservice.exception.BookNotFoundException;
import by.edu.bookservice.exception.util.BookExceptionResponse;
import by.edu.bookservice.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/books")
@RequiredArgsConstructor
@Tag(name ="Book Controller", description = "Book API")
public class BookController {

    private final BookService bookService;

    @GetMapping
    @Operation(summary = "Get all books")
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get book by id")
    public BookDTO getBookById(@PathVariable String id) {
        return bookService.getById(id);
    }

    @GetMapping("/isbn/{isbn}")
    @Operation(summary = "Get book by ISBN")
    public BookDTO getBookByISBN(@PathVariable String isbn) {
        return bookService.getByISBN(isbn);
    }

    @PostMapping
    @Operation(summary = "Add a book")
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) throws URISyntaxException {
        String id = bookService.createBook(bookDTO);
        BookDTO book = bookService.getById(id);

        return ResponseEntity.created(new URI(String.format("api/books/%s", id))).body(book);
    }

    @GetMapping("/{id}/borrow")
    @Operation(summary = "Borrow book")
    public BookDTO borrowBook(@PathVariable String id) {
        return bookService.borrowBook(id);
    }

    @GetMapping("/{id}/return")
    @Operation(summary = "Return book")
    public void returnBook(@PathVariable String id) {
        bookService.returnBook(id);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update book")
    public BookDTO updateBook(@RequestBody BookDTO bookDTO, @PathVariable String id) {
        return bookService.updateBook(bookDTO, id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete book")
    public void deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/available")
    @Operation(summary = "Get available books")
    public List<BookDTO> getAvailableBooks() {
        return bookService.getAllBooks();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public BookExceptionResponse handleNotFoundException(BookNotFoundException ex) {
        BookExceptionResponse response = new BookExceptionResponse();
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(ex.getMessage());

        return response;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public BookExceptionResponse handleUnavailableException(BookNotFoundException ex) {
        BookExceptionResponse response = new BookExceptionResponse();
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(ex.getMessage());

        return response;
    }
}
