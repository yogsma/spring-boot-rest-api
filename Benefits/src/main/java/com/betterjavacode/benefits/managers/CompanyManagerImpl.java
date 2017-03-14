package com.betterjavacode.benefits.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.betterjavacode.benefits.entities.Company;
import com.betterjavacode.benefits.interfaces.CompanyManager;
import com.betterjavacode.benefits.repositories.CompanyRepository;

public class CompanyManagerImpl implements CompanyManager {

    private CompanyRepository companyRepository;

    @Autowired
    public void setCompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company createCompany(Company company) {
        if (company != null) {
            Company c = companyRepository.save(company);
            return c;
        }
        return null;
    }

    @Override
    public Company updateCompany(Company company) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Company getCompany(int guid) {
        Company company = companyRepository.findOne(guid);
        if (company == null) {
            return null;
        }

        return company;
    }

    @Override
    public List<Company> getAllCompanies() {
        List<Company> cList = (List<Company>) companyRepository.findAll();
        return cList;
    }

    @Override
    public void deleteCompany(int guid) {
        Company c = companyRepository.findOne(guid);
        if (c == null) {
            return;
        }
        companyRepository.delete(guid);

    }

}
