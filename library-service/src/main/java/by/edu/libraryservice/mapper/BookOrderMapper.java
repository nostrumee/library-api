package by.edu.libraryservice.mapper;

import by.edu.libraryservice.dto.BookOrderDTO;
import by.edu.libraryservice.entity.BookOrder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookOrderMapper {
    BookOrderDTO toDTO(BookOrder order);
}
