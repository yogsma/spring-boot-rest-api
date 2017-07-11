package com.betterjavacode.benefits.managers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.betterjavacode.benefits.entities.Company;
import com.betterjavacode.benefits.interfaces.CompanyManager;
import com.betterjavacode.benefits.models.UserModel;
import com.betterjavacode.benefits.repositories.CompanyRepository;
import com.betterjavacode.benefits.utilities.InvalidRequestException;

public class CompanyManagerImpl implements CompanyManager {

    public static final Logger LOGGER = LogManager.getLogger(CompanyManagerImpl.class);
    private CompanyRepository companyRepository;

    @Autowired
    public void setCompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company createCompany(Company company) {
        LOGGER.info(" Enter >> createCompany() ");
        if (company == null) {
            throw new InvalidRequestException(400, "Company object passed is null");
        }

        Company c = companyRepository.save(company);
        LOGGER.info(" Exit << createCompany() ");
        return c;
    }

    @Override
    public Company updateCompany(Company company) {
        LOGGER.info("Enter >> updateCompany() ");
        Company oldcompany = companyRepository.findOne(company.getId());
        if (oldcompany == null) {
            throw new InvalidRequestException(400, "Company does not exist");
        }
        company.getCp()
            .setId(oldcompany.getCp()
                .getId());
        Company c = companyRepository.save(company);
        LOGGER.info("Exit << updateCompany() ");
        return c;
    }

    @Override
    public Company getCompany(int guid) {
        LOGGER.info(" Enter >> getCompany() ");
        Company company = companyRepository.findOne(guid);
        if (company == null) {
            LOGGER.info(" Exit << createCompany() ");
            throw new InvalidRequestException(400, "Company not found");
        }
        LOGGER.info(" Exit << getCompany() ");
        return company;
    }

    @Override
    public List<Company> getAllCompanies() {
        LOGGER.info(" Enter >> getAllCompanies() ");
        List<Company> cList = (List<Company>) companyRepository.findAll();
        LOGGER.info(" Exit << getAllCompanies() ");
        return cList;
    }

    @Override
    public void deleteCompany(int guid) {
        LOGGER.info(" Enter >> deleteCompany() ");
        Company c = companyRepository.findOne(guid);
        if (c == null) {
            LOGGER.info(" Exit << deleteCompany() ");
            throw new InvalidRequestException(400, "Compay not found");
        }
        LOGGER.info(" Exit << deleteCompany() ");
        companyRepository.delete(guid);

    }

    @Override
    public List<UserModel> getAllEmployeesOfACompany(int companyid) {
        LOGGER.info(" Enter >> getAllEmployeesOfACompany() ");
        Company c = companyRepository.findOne(companyid);
        if (c == null) {
            LOGGER.info(" Company not found");
            throw new InvalidRequestException(400, "Company does not exist");
        }

        LOGGER.info(" Exit << getAllEmployeesOfACompany() ");
        return null;
    }

}
