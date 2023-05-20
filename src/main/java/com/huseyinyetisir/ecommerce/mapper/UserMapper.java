package com.huseyinyetisir.ecommerce.mapper;

import com.huseyinyetisir.ecommerce.dto.UserDto;
import com.huseyinyetisir.ecommerce.dto.UserSaveRequest;
import com.huseyinyetisir.ecommerce.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    User convertToUser(UserSaveRequest userSaveRequest);

    UserDto convertToUserDto(User user);

    List<UserDto> convertToUserDtoList(List<User> userList);

    UserDto convertToUserOptional(Optional<User> userOptional);
}
