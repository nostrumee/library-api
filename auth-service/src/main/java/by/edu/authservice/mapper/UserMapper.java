package by.edu.authservice.mapper;

import by.edu.authservice.dto.UserDTO;
import by.edu.authservice.entity.User;
import by.edu.authservice.security.JwtEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    JwtEntity toJwtEntity(User user);

    UserDTO toDTO(User user);

    User toEntity(UserDTO userDTO);

}
