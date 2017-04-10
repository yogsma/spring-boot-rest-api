package com.betterjavacode.benefits.views;

import org.springframework.web.client.RestTemplate;

import com.betterjavacode.benefits.entities.Company;

public class CompanyClient {

    public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        String resourceAPI_URL = "http://localhost:8080/benefits/v1/companies/{id}";
        Company company = restTemplate.getForObject(resourceAPI_URL, Company.class, 1);

        System.out.println("ID: " + company.getId());
        System.out.println("Name: " + company.getName());
        System.out.println("Status: " + company.getStatusid());

        String resourceAPI_POSTURL = "http://localhost:8080/benefits/v1/companies/";
        Company comp = new Company();
        comp.setName("XYZ Company");
        comp.setStatusid(1);
        comp.setType("Corporation");
        comp.setEin("9343423232");
        // comp.setCp(cp);
        Company newcomp = restTemplate.postForObject(resourceAPI_POSTURL, comp, Company.class);

        System.out.println("ID: " + newcomp.getId());
        System.out.println("Name: " + newcomp.getName());
        System.out.println("Status: " + newcomp.getStatusid());
    }

}
