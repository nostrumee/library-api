package by.edu.libraryservice.service.impl;

import by.edu.libraryservice.dto.BookOrderDTO;
import by.edu.libraryservice.entity.BookOrder;
import by.edu.libraryservice.mapper.BookOrderMapper;
import by.edu.libraryservice.repository.BookOrderRepository;
import by.edu.libraryservice.service.BookOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookOrderServiceImpl implements BookOrderService {

    private final BookOrderRepository bookOrderRepository;
    private final BookOrderMapper bookOrderMapper;

    @Override
    @Transactional
    public void createOrder(String bookId) {
        BookOrder bookOrder = new BookOrder();
        bookOrder.setBookId(Integer.parseInt(bookId.substring(1, bookId.length() - 1)));
        bookOrder.setDateBorrowed(LocalDate.now());
        bookOrder.setDateToReturn(LocalDate.now().plusWeeks(1));

        bookOrderRepository.save(bookOrder);
    }

    @Override
    @Transactional
    public void deleteOrder(String bookId) {
        System.out.println(bookId + "SERVICE");
        bookOrderRepository.deleteByBookId(Integer.parseInt(bookId.substring(1, bookId.length() - 1)));
    }

    @Override
    public List<BookOrderDTO> getAllOrders() {
        return bookOrderRepository.findAll()
                .stream()
                .map(bookOrderMapper::toDTO)
                .collect(Collectors.toList());
    }
}
