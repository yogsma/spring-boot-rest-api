package com.betterjavacode.benefits.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.betterjavacode.benefits.entities.User;
import com.betterjavacode.benefits.interfaces.UserManager;

/**
 * 
 * @author Yogesh Mali
 *
 */
@Controller
public class LoginController {

    public static final Logger LOGGER = LogManager.getLogger(LoginController.class);

    @Autowired
    UserManager userManager;

    /**
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userpage(Model model) {
        LOGGER.info(" Enter >> userpage() ");
        Authentication auth = SecurityContextHolder.getContext()
            .getAuthentication();
        String name = auth.getName();
        User user = userManager.findUserByEmail(name);
        model.addAttribute("name", user.getFirstname());
        model.addAttribute("userid", user.getId());
        LOGGER.info(" Exit << userpage() ");
        return "user";
    }

    /**
     * 
     * @return
     */
    @RequestMapping(value = { "/login" })
    public String login() {
        return "login";
    }

    /**
     * 
     * @return
     */
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String Error403() {
        return "403";
    }
}
