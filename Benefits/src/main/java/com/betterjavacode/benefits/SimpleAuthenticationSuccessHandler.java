package com.betterjavacode.benefits;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class SimpleAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    public static final Logger LOGGER = LogManager.getLogger(SimpleAuthenticationSuccessHandler.class);

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest arg0, HttpServletResponse arg1, Authentication authentication) throws IOException, ServletException {
        LOGGER.info(" Enter >> onAuthenticationSuccess() ");
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority ga : authorities) {
            if (ga.getAuthority()
                .equals("USER")) {
                try {
                    LOGGER.info(" USER role ...");
                    redirectStrategy.sendRedirect(arg0, arg1, "/user");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (ga.getAuthority()
                .equals("ADMIN")) {
                try {
                    LOGGER.info(" ADMIN role ...");
                    redirectStrategy.sendRedirect(arg0, arg1, "/home");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    LOGGER.info(" No role defined...");
                    redirectStrategy.sendRedirect(arg0, arg1, "/403");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // throw new IllegalStateException();
            }
        }
    }

}
