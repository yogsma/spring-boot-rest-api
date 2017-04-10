package com.betterjavacode.benefits.controller;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.betterjavacode.benefits.entities.Company;
import com.betterjavacode.benefits.interfaces.CompanyManager;
import com.betterjavacode.benefits.models.UserModel;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("benefits/v1")
public class CompanyService {

    @Autowired
    CompanyManager compMgr;

    @RequestMapping(value = "/companies/", method = RequestMethod.POST)
    @ApiOperation(value = "create a new company", response = Company.class)
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid Input") })
    public Company createCompany(@RequestBody Company company) {
        Company c = compMgr.createCompany(company);
        return c;
    }

    @RequestMapping(value = "/companies/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get a company", response = Company.class)
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid Input") })
    public Company getCompany(@PathVariable("id") int id) {
        Company c = compMgr.getCompany(id);
        return c;
    }

    @RequestMapping(value = "/companies/", method = RequestMethod.GET)
    @ApiOperation(value = "List all companies", response = Company.class)
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid Input") })
    public List<Company> getAllCompanies() {
        List<Company> cList = compMgr.getAllCompanies();
        return cList;
    }

    @RequestMapping(value = "/companies/", method = RequestMethod.PUT)
    @ApiOperation(value = "Update a  company", response = Company.class)
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid Input") })
    public Company updateCompany(@RequestBody Company company) {
        Company c = compMgr.updateCompany(company);
        return c;
    }

    @RequestMapping(value = "/companies/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete a company")
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid Input") })
    public Response deleteCompany(@PathVariable("id") int id) {
        compMgr.deleteCompany(id);
        return Response.status(Response.Status.OK)
            .build();
    }

    @RequestMapping(value = "/companies/{id}/users", method = RequestMethod.GET)
    @ApiOperation(value = "Return employees of a company")
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid Input") })
    public List<UserModel> getAllEmployeesOfACompany(@PathVariable("id") int id) {
        List<UserModel> listUsers = compMgr.getAllEmployeesOfACompany(id);

        return listUsers;
    }
}
