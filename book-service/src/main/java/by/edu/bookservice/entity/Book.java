package by.edu.bookservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_id_sequence"
    )
    private Integer id;

    @Column(unique = true)
    @NotBlank(message = "ISBN must not be blank")
    @NotNull(message = "ISBN must not be null")
    private String isbn;

    private String title;

    private String genre;

    private String description;

    private String author;

    @Enumerated(EnumType.STRING)
    private Status status;
}
