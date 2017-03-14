package com.betterjavacode.benefits;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.betterjavacode.benefits" })
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

}
