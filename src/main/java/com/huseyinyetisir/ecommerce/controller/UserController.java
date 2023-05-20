package com.huseyinyetisir.ecommerce.controller;


import com.huseyinyetisir.ecommerce.dto.UserDto;
import com.huseyinyetisir.ecommerce.dto.UserSaveRequest;
import com.huseyinyetisir.ecommerce.exception.ItemNotFoundException;
import com.huseyinyetisir.ecommerce.general.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserControllerContract userControllerContract;


    @PostMapping
    public ResponseEntity<RestResponse<UserDto>> saveUser(@RequestBody UserSaveRequest userSaveRequest){
        var userDto = userControllerContract.save(userSaveRequest);
        return ResponseEntity.ok(RestResponse.of(userDto));
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<UserDto>>> getAllUser(){
         var userDtoList = userControllerContract.getAllUser();
        return ResponseEntity.ok(RestResponse.of(userDtoList));
    }
    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<UserDto>> getUserById(@PathVariable Long id){
        UserDto userDto = userControllerContract.getUserById(id);
        return ResponseEntity.ok(RestResponse.of(userDto));
    }

//    @GetMapping("/{username}")
//    public ResponseEntity<RestResponse<UserDto>> getUserByUserName(@PathVariable String username){
//        UserDto userDto = userControllerContract.getUserByUserName(username);
//        return ResponseEntity.ok(RestResponse.of(userDto));
//    }

    @RequestMapping(value = "/{id}/{phoneNumber}", method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse<Object>> deleteUser(@PathVariable Long id, @PathVariable String phoneNumber){
        userControllerContract.delete(id,phoneNumber);
        return ResponseEntity.ok(RestResponse.empty());
    }
}
