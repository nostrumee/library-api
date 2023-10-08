package by.edu.bookservice.service.impl;

import by.edu.bookservice.dto.BookDTO;
import by.edu.bookservice.entity.Book;
import by.edu.bookservice.entity.Status;
import by.edu.bookservice.exception.BookNotFoundException;
import by.edu.bookservice.exception.BookUnavailableException;
import by.edu.bookservice.mapper.BookMapper;
import by.edu.bookservice.repository.BookRepository;
import by.edu.bookservice.service.BookService;
import by.edu.bookservice.service.MessageProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static by.edu.bookservice.exception.util.ExceptionUtil.*;
import static by.edu.commonrabbitmq.RabbitQueue.BORROW_QUEUE;
import static by.edu.commonrabbitmq.RabbitQueue.RETURN_QUEUE;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final MessageProducer messageProducer;

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO getById(String id) {
        Optional<Book> optionalBook = bookRepository.findById(Integer.parseInt(id));
        if (optionalBook.isPresent()) {
            return bookMapper.toDTO(optionalBook.get());
        } else {
            log.error("Book with id {} was not found", id);
            throw new BookNotFoundException(String.format(BOOK_NOT_FOUND_ID_MESSAGE, id));
        }
    }

    @Override
    public BookDTO getByISBN(String isbn) {
        Optional<Book> optionalBook = bookRepository.findByIsbn(isbn);
        if (optionalBook.isPresent()) {
            return bookMapper.toDTO(optionalBook.get());
        } else {
            log.error("Book with ISBN {} was not found", isbn);
            throw new BookNotFoundException(String.format(BOOK_NOT_FOUND_ISBN_MESSAGE, isbn));
        }
    }

    @Override
    public String createBook(BookDTO bookDTO) {
        Book book = bookRepository.save(bookMapper.toEntity(bookDTO));
        return book.getId().toString();
    }

    @Override
    public BookDTO borrowBook(String id) {
        Optional<Book> optionalBook = bookRepository.findById(Integer.parseInt(id));
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();

            if (book.getStatus() == Status.UNAVAILABLE) {
                throw new BookUnavailableException(BOOK_UNAVAILABLE_MESSAGE);
            }

            book.setStatus(Status.UNAVAILABLE);
            bookRepository.save(book);
            messageProducer.produce(BORROW_QUEUE, id);
            return bookMapper.toDTO(book);
        } else {
            log.error("Book with id {} was not found", id);
            throw new BookNotFoundException(String.format(BOOK_NOT_FOUND_ID_MESSAGE, id));
        }
    }

    @Override
    public void returnBook(String id) {
        Optional<Book> optionalBook = bookRepository.findById(Integer.parseInt(id));
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setStatus(Status.AVAILABLE);
            messageProducer.produce(RETURN_QUEUE, id);
        } else {
            log.error("Book with id {} was not found", id);
            throw new BookNotFoundException(String.format(BOOK_NOT_FOUND_ID_MESSAGE, id));
        }
    }

    @Override
    public BookDTO updateBook(BookDTO bookDTO, String id) {
        Optional<Book> optionalBook = bookRepository.findById(Integer.parseInt(id));
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            bookMapper.updateBookFromDTO(bookDTO, book);
            bookRepository.save(book);

            return bookMapper.toDTO(book);
        } else {
            log.error("Book with id {} was not found", id);
            throw new BookNotFoundException(String.format(BOOK_NOT_FOUND_ID_MESSAGE, id));
        }
    }

    @Override
    public void deleteBook(String id) {
        Optional<Book> optionalBook = bookRepository.findById(Integer.parseInt(id));
        if (optionalBook.isPresent()) {
            bookRepository.deleteById(Integer.parseInt(id));
        } else {
            log.error("Book with id {} was not found", id);
            throw new BookNotFoundException(String.format(BOOK_NOT_FOUND_ID_MESSAGE, id));
        }
    }

    @Override
    public List<BookDTO> getAvailableBooks() {
        return bookRepository.findAvailableBooks()
                .stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }
}
