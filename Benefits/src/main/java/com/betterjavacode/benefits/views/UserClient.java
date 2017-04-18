package com.betterjavacode.benefits.views;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.betterjavacode.benefits.soap.GetUserRequest;
import com.betterjavacode.benefits.soap.GetUserResponse;

public class UserClient extends WebServiceGatewaySupport {

    public GetUserResponse getUserById(int userid) {
        GetUserRequest userrequest = new GetUserRequest();
        userrequest.setId(userid);
        GetUserResponse response = (GetUserResponse) getWebServiceTemplate().marshalSendAndReceive(userrequest, new SoapActionCallback("http://localhost:8080/benefits/endpoints/getUserResponse"));
        return response;
    }
}
