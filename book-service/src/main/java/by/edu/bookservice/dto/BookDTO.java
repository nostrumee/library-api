package by.edu.bookservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Book DTO")
public class BookDTO {

    @Schema(description = "ISBN", example = "978-0345391803")
    private String isbn;

    @Schema(description = "title", example = "Dune")
    private String title;

    @Schema(description = "genre", example = "Science Fiction")
    private String genre;

    @Schema(description = "description", example = "A epic science fiction novel")
    private String description;

    @Schema(description = "author", example = "Frank Herbert")
    private String author;

}
