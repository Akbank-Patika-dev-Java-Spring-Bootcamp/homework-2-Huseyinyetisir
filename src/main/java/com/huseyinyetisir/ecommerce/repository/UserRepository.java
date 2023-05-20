package com.huseyinyetisir.ecommerce.repository;

import com.huseyinyetisir.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long>{


    @Query(
            "select user from User user where user.username = :username"
    )
    Optional<User> findByUsername(String username);

    User findByNameAndSurname(String name, String surname);

    List<User> findByIdBetween(Long first, Long last);

}
