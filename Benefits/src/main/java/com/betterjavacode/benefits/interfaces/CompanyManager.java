package com.betterjavacode.benefits.interfaces;

import java.util.List;

import com.betterjavacode.benefits.entities.Company;
import com.betterjavacode.benefits.models.UserModel;

public interface CompanyManager {

    public Company createCompany(Company company);

    public Company updateCompany(Company company);

    public Company getCompany(int guid);

    public List<Company> getAllCompanies();

    public void deleteCompany(int guid);

    public List<UserModel> getAllEmployeesOfACompany(int companyid);
}
