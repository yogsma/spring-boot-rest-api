package com.betterjavacode.benefits.controller;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.betterjavacode.benefits.entities.Company;
import com.betterjavacode.benefits.interfaces.CompanyManager;

@RestController
@RequestMapping("benefits/v1")
public class CompanyService {

    @Autowired
    CompanyManager compMgr;

    @RequestMapping(value = "/companies/", method = RequestMethod.POST)
    public Company createCompany(Company company) {
        Company c = compMgr.createCompany(company);
        return c;
    }

    @RequestMapping(value = "/companies/{id}", method = RequestMethod.GET)
    public Company getCompany(@PathVariable("id") int id) {
        Company c = compMgr.getCompany(id);
        return c;
    }

    @RequestMapping(value = "/companies/", method = RequestMethod.GET)
    public List<Company> getAllCompanies() {
        List<Company> cList = compMgr.getAllCompanies();
        return cList;
    }

    @RequestMapping(value = "/companies/", method = RequestMethod.PUT)
    public Company updateCompany(Company company) {
        Company c = compMgr.updateCompany(company);
        return c;
    }

    @RequestMapping(value = "/companies/{id}", method = RequestMethod.DELETE)
    public Response deleteCompany(@PathVariable("id") int id) {
        compMgr.deleteCompany(id);
        return Response.status(Response.Status.OK)
            .build();
    }
}
