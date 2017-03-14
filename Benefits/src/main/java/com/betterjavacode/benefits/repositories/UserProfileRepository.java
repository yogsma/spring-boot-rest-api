package com.betterjavacode.benefits.repositories;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.data.repository.CrudRepository;

import com.betterjavacode.benefits.entities.UserProfile;

public interface UserProfileRepository extends CrudRepository<UserProfile, Integer> {

}
