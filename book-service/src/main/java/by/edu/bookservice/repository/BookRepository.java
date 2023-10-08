package by.edu.bookservice.repository;

import by.edu.bookservice.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findByIsbn(String isbn);

    @Query("SELECT b FROM Book b WHERE b.status = 'AVAILABLE'")
    List<Book> findAvailableBooks();
}
