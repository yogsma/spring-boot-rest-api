package com.betterjavacode.benefits.repositories;

import org.springframework.data.repository.CrudRepository;

import com.betterjavacode.benefits.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    // public User getUserByGuid(String guid);
}
