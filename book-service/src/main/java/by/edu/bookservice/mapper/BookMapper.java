package by.edu.bookservice.mapper;

import by.edu.bookservice.dto.BookDTO;
import by.edu.bookservice.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface BookMapper {

    BookDTO toDTO(Book book);

    Book toEntity(BookDTO bookDTO);

    void updateBookFromDTO(BookDTO bookDTO, @MappingTarget Book book);
}
