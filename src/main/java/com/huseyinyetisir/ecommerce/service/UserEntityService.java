package com.huseyinyetisir.ecommerce.service;


import com.huseyinyetisir.ecommerce.entity.User;
import com.huseyinyetisir.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserEntityService extends BaseEntityService<User, UserRepository>{


    public UserEntityService(UserRepository userRepository){
        super(userRepository);
    }


    public boolean phoneNumberControl(Long id, String phoneNumber){
        if (getUserById(id).equals(phoneNumber)){

        }
    }

}
