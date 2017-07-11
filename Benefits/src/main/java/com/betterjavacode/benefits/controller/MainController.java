package com.betterjavacode.benefits.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    public static final Logger LOGGER = LogManager.getLogger(MainController.class);

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homepage() {
        LOGGER.info(" Enter >> homepage() ");
        return "index";
    }
}
