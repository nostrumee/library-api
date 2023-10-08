package by.edu.libraryservice.controller;

import by.edu.libraryservice.dto.BookOrderDTO;
import by.edu.libraryservice.service.BookOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/book-orders")
@Tag(name ="Book Order Controller", description = "Book Order API")
public class BookOrderController {

    private final BookOrderService bookOrderService;

    @GetMapping
    @Operation(summary = "Get all orders")
    public List<BookOrderDTO> getAllOrders() {
        return bookOrderService.getAllOrders();
    }
}
