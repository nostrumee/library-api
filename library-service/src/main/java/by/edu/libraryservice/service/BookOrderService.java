package by.edu.libraryservice.service;

import by.edu.libraryservice.dto.BookOrderDTO;

import java.util.List;

public interface BookOrderService {

    void createOrder(String bookId);

    void deleteOrder(String bookId);

    List<BookOrderDTO> getAllOrders();
}
