package by.edu.libraryservice.repository;

import by.edu.libraryservice.entity.BookOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookOrderRepository extends JpaRepository<BookOrder, Integer> {
    void deleteByBookId(Integer bookId);
}
