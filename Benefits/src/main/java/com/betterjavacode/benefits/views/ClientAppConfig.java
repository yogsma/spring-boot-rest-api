package com.betterjavacode.benefits.views;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ClientAppConfig {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.betterjavacode.benefits.soap");
        return marshaller;
    }

    @Bean
    public UserClient userClient(Jaxb2Marshaller marshaller) {
        // WSDL URL - http://localhost:8080/benefits/endpoints/users.wsdl
        UserClient uc = new UserClient();
        uc.setDefaultUri("http://localhost:8080/benefits/endpoints/users.wsdl");
        uc.setMarshaller(marshaller);
        uc.setUnmarshaller(marshaller);
        return uc;
    }
}
