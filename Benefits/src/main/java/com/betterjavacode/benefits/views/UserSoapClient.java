package com.betterjavacode.benefits.views;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.betterjavacode.benefits.soap.GetUserResponse;

public class UserSoapClient {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ClientAppConfig.class);
        ctx.refresh();
        UserClient usc = ctx.getBean(UserClient.class);
        System.out.println(" For Employee: ");
        GetUserResponse response = usc.getUserById(1);
        System.out.println("Name: " + response.getUser()
            .getFirstname() + " "
            + response.getUser()
                .getLastname());
        System.out.println(" Job: " + response.getUser()
            .getJobtitle());

    }

}
