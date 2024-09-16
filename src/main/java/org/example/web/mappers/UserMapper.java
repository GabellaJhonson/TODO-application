package org.example.web.mappers;

import org.example.domain.user.User;
import org.example.web.dto.user.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "string")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto dto);
}
