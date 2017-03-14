package com.betterjavacode.benefits.repositories;

import org.springframework.data.repository.CrudRepository;

import com.betterjavacode.benefits.entities.CompanyProfile;

public interface CompanyProfileRepository extends CrudRepository<CompanyProfile, Integer> {

}
