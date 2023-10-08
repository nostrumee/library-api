package by.edu.bookservice.exception.util;

import lombok.Data;

@Data
public class BookExceptionResponse {
    private int status;
    private String message;
}
