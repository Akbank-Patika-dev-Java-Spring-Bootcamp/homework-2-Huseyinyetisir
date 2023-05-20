package com.huseyinyetisir.ecommerce.service;

import com.huseyinyetisir.ecommerce.entity.BaseEntity;
import com.huseyinyetisir.ecommerce.entity.User;
import com.huseyinyetisir.ecommerce.general.BaseAdditionalFields;
import com.huseyinyetisir.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public abstract class BaseEntityService <E extends BaseEntity, R extends JpaRepository<E,Long>> {

    private final R repository;


    public E save (E e){
        BaseAdditionalFields baseAdditionalFields = e.getBaseAdditionalFields();
        if (baseAdditionalFields == null){
            baseAdditionalFields = new BaseAdditionalFields();
        }
        if(e.getId() == null){
            baseAdditionalFields.setCreateDate(LocalDateTime.now());
        }
        baseAdditionalFields.setUpdateDate(LocalDateTime.now());
        e.setBaseAdditionalFields(baseAdditionalFields);
        e = repository.save(e);
        return e;
    }

    public List<E> getAllUser(){return repository.findAll();}

    public Optional<E> getUserById(Long id) {
        return repository.findById(id);
    }

//    public Optional<E> getUserByUserName(String username) {
//        return repository.findBy(Optional<User>)
//    }

    public void deleteUser(Long id){
        repository.deleteById(id);
    }
}
