package com.huseyinyetisir.ecommerce.controller;

import com.huseyinyetisir.ecommerce.dto.UserDto;
import com.huseyinyetisir.ecommerce.dto.UserSaveRequest;

import java.util.List;

public interface UserControllerContract {
    UserDto save(UserSaveRequest userSaveRequest);

    List<UserDto> getAllUser();

    UserDto getUserById(Long id);

    void delete(Long id,String phoneNumber);

//    UserDto getUserByUserName(String username);
}
