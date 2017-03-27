package com.betterjavacode.benefits.managers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.betterjavacode.benefits.entities.User;
import com.betterjavacode.benefits.interfaces.UserManager;
import com.betterjavacode.benefits.repositories.UserRepository;
import com.betterjavacode.benefits.utilities.InvalidRequestException;

public class UserManagerImpl implements UserManager {

    public static final Logger LOGGER = LogManager.getLogger(UserManagerImpl.class);
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User u) {
        LOGGER.info(" Enter >> createUser() ");
        if (u != null) {
            User user = userRepository.save(u);
            LOGGER.info(" Exit << createUser() ");
            return user;
        } else {
            LOGGER.info(" Exit << createUser() ");
            throw new InvalidRequestException(400, "User is null");
        }
    }

    @Override
    public User updateUser(User u) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User getUser(int id) {
        LOGGER.info(" Enter >> getUser() ");
        User user = userRepository.findOne(id);
        if (user == null) {
            LOGGER.info(" Exit << getUser() ");
            throw new InvalidRequestException(400, "User not found ");
        }
        LOGGER.info(" Exit << getUser() ");
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        LOGGER.info(" Enter >> getAllUsers() ");
        List<User> userList = (List<User>) userRepository.findAll();
        LOGGER.info(" Exit << getAllUsers() ");
        return userList;
    }

    @Override
    public void deleteUser(int guid) {
        // TODO Auto-generated method stub
        LOGGER.info(" Enter >> deleteUser() ");
        User user = userRepository.findOne(guid);
        if (user == null) {
            LOGGER.info(" Exit << deleteUser() ");
            throw new InvalidRequestException(400, "User not found");
        }
        LOGGER.info(" Exit << deleteUser() ");
        userRepository.delete(user);
    }

}
