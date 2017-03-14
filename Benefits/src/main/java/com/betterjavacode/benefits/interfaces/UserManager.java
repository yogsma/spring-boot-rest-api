package com.betterjavacode.benefits.interfaces;

import java.util.List;

import com.betterjavacode.benefits.entities.User;

public interface UserManager {

    public User createUser(User u);

    public User updateUser(User u);

    public User getUser(int id);

    public List<User> getAllUsers();

    public void deleteUser(int id);
}
