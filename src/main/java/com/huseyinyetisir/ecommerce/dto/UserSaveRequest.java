package com.huseyinyetisir.ecommerce.dto;

import com.huseyinyetisir.ecommerce.enums.UserType;

public record UserSaveRequest (
        String name,
        String surname,
        String username,
        String password,
        String email,
        UserType userType){
}
