package by.edu.libraryservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

@Data
@Schema(description = "Book Order DTO")
public class BookOrderDTO {

    @Schema(description = "Book id", example = "1")
    private Integer bookId;

    @Schema(description = "Date Borrowed", example = "08-10-2023")
    private LocalDate dateBorrowed;

    @Schema(description = "Date To Return", example = "16-10-2023")
    private LocalDate dateToReturn;

}
