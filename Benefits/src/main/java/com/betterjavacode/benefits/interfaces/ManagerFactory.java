package com.betterjavacode.benefits.interfaces;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.betterjavacode.benefits.managers.CompanyManagerImpl;
import com.betterjavacode.benefits.managers.UserManagerImpl;

@Configuration
public class ManagerFactory {
    @Bean
    public CompanyManager getCompanyManager() {
        return new CompanyManagerImpl();
    }

    @Bean
    public UserManager getUserManager() {
        return new UserManagerImpl();
    }
}
