package com.huseyinyetisir.ecommerce.controller;


import com.huseyinyetisir.ecommerce.dto.UserDto;
import com.huseyinyetisir.ecommerce.dto.UserSaveRequest;
import com.huseyinyetisir.ecommerce.entity.User;
import com.huseyinyetisir.ecommerce.errorMessages.UserErrorMessages;
import com.huseyinyetisir.ecommerce.exception.ItemNotFoundException;
import com.huseyinyetisir.ecommerce.mapper.UserMapper;
import com.huseyinyetisir.ecommerce.service.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserControllerContractImpl implements UserControllerContract{

    private final UserEntityService userEntityService;
    @Override
    public UserDto save(UserSaveRequest userSaveRequest){
        User user = UserMapper.INSTANCE.convertToUser(userSaveRequest);
        user = userEntityService.save(user);
        return UserMapper.INSTANCE.convertToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUser(){
        List<User> userList = userEntityService.getAllUser();
        return UserMapper.INSTANCE.convertToUserDtoList(userList);
    }

    @Override
    public UserDto getUserById(Long id){
        Optional<User> userOptional = userEntityService.getUserById(id);
        if (userOptional.isPresent()){
        return UserMapper.INSTANCE.convertToUserDto(userOptional.get());
    }
        throw new ItemNotFoundException(UserErrorMessages.USER_NOT_FOUND);
    }
//    @Override
//    public UserDto getUserByUserName(String username){
//        Optional<User> userOptional = userEntityService.getUserByUserName(username);
//        if (userOptional.isPresent()){
//            return UserMapper.INSTANCE.convertToUserDto(userOptional.get());
//        }
//        throw new ItemNotFoundException(UserErrorMessages.USER_NOT_FOUND);
//    }
    @Override
    public void delete(Long id, String phoneNumber){
        userEntityService.deleteUser(id);
    }
}
