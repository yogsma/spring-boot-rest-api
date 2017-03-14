package com.betterjavacode.benefits.controller;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.betterjavacode.benefits.entities.User;
import com.betterjavacode.benefits.interfaces.UserManager;

@RestController
@RequestMapping("benefits/v1")
public class UserService {

    @Autowired
    UserManager userMgr;

    @RequestMapping(value = "/users/", method = RequestMethod.POST)
    public User createUser(User user) {
        User u = userMgr.createUser(user);
        return u;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") int id) {
        User u = userMgr.getUser(id);
        return u;
    }

    @RequestMapping(value = "/users/", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        List<User> cList = userMgr.getAllUsers();
        return cList;
    }

    @RequestMapping(value = "/users/", method = RequestMethod.PUT)
    public User updateUser(User user) {
        User u = userMgr.updateUser(user);
        return u;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public Response deleteUser(@PathVariable("id") int id) {
        userMgr.deleteUser(id);
        return Response.status(Response.Status.OK)
            .build();
    }
}
