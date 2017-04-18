package com.betterjavacode.benefits.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betterjavacode.benefits.entities.User;
import com.betterjavacode.benefits.repositories.UserRepository;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public com.betterjavacode.benefits.soap.User getUserDetails(int id) {
        User user = userRepository.findOne(id);
        com.betterjavacode.benefits.soap.User soapUser = new com.betterjavacode.benefits.soap.User();
        soapUser.setId(user.getId());
        soapUser.setFirstname(user.getFirstname());
        soapUser.setMiddlename(user.getMiddlename());
        soapUser.setLastname(user.getLastname());
        soapUser.setJobtitle(user.getJobtitle());
        soapUser.setUsername(user.getUsername());
        soapUser.setCreatedate(null);

        return soapUser;
    }

}
