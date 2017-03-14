package com.betterjavacode.benefits.repositories;

import org.springframework.data.repository.CrudRepository;

import com.betterjavacode.benefits.entities.Company;

public interface CompanyRepository extends CrudRepository<Company, Integer> {

    // public Company getCompanyByGuid(String guid);
}
