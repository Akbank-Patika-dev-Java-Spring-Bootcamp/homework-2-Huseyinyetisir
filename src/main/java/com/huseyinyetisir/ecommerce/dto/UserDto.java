package com.huseyinyetisir.ecommerce.dto;

import com.huseyinyetisir.ecommerce.enums.UserType;

public record UserDto (
        Long id,
        String name,
        String surname,
        String username,
        String email,
        UserType userType) {
}
