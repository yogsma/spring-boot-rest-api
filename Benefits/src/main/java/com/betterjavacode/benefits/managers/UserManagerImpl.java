package com.betterjavacode.benefits.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.betterjavacode.benefits.entities.User;
import com.betterjavacode.benefits.interfaces.UserManager;
import com.betterjavacode.benefits.repositories.UserRepository;

public class UserManagerImpl implements UserManager {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User u) {
        if (u != null) {
            User user = userRepository.save(u);
            return user;
        } else {
            return null;
        }
    }

    @Override
    public User updateUser(User u) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User getUser(int id) {
        User user = userRepository.findOne(id);
        if (user == null) {
            return null;
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = (List<User>) userRepository.findAll();
        return userList;
    }

    @Override
    public void deleteUser(int guid) {
        // TODO Auto-generated method stub
        User user = userRepository.findOne(guid);
        if (user == null) {
            return;
        }
        userRepository.delete(user);
    }

}
