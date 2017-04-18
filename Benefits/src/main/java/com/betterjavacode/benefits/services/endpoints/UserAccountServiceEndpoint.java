package com.betterjavacode.benefits.services.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.betterjavacode.benefits.services.UserAccountService;
import com.betterjavacode.benefits.soap.GetUserRequest;
import com.betterjavacode.benefits.soap.GetUserResponse;
import com.betterjavacode.benefits.soap.User;

@Endpoint
public class UserAccountServiceEndpoint {

    // private static final String TARGET_NAMESPACE = "http://com/betterjavacode/benefits/webservices/useraccountservice";
    private static final String TARGET_NAMESPACE = "http://betterjavacode.com/benefits/soap";

    @Autowired
    private UserAccountService userAccountService;

    @PayloadRoot(localPart = "getUserRequest", namespace = TARGET_NAMESPACE)
    public @ResponsePayload GetUserResponse getUserRequest(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        User user = userAccountService.getUserDetails(request.getId());
        response.setUser(user);
        return response;
    }
}
