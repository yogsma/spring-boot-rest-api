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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("benefits/v1")
public class UserService {

    @Autowired
    UserManager userMgr;

    @RequestMapping(value = "/users/", method = RequestMethod.POST)
    @ApiOperation(value = "Create a new user", response = User.class)
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid Input") })
    public User createUser(User user) {
        User u = userMgr.createUser(user);
        return u;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get a user", response = User.class)
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid Input") })
    public User getUser(@PathVariable("id") int id) {
        User u = userMgr.getUser(id);
        return u;
    }

    @RequestMapping(value = "/users/", method = RequestMethod.GET)
    @ApiOperation(value = "List all users", response = User.class)
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid Input") })
    public List<User> getAllUsers() {
        List<User> cList = userMgr.getAllUsers();
        return cList;
    }

    @RequestMapping(value = "/users/", method = RequestMethod.PUT)
    @ApiOperation(value = "Update a user", response = User.class)
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid Input") })
    public User updateUser(User user) {
        User u = userMgr.updateUser(user);
        return u;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete a user", response = User.class)
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid Input") })
    public Response deleteUser(@PathVariable("id") int id) {
        userMgr.deleteUser(id);
        return Response.status(Response.Status.OK)
            .build();
    }
}
