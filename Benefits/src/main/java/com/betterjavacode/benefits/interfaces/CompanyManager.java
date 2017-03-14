package com.betterjavacode.benefits.interfaces;

import java.util.List;

import com.betterjavacode.benefits.entities.Company;

public interface CompanyManager {

    public Company createCompany(Company company);

    public Company updateCompany(Company company);

    public Company getCompany(int guid);

    public List<Company> getAllCompanies();

    public void deleteCompany(int guid);
}
