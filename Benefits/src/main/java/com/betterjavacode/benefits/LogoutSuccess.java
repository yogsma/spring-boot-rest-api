package com.betterjavacode.benefits;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Yogesh Mali
 *
 */
@Component
public class LogoutSuccess implements LogoutSuccessHandler {

    public static final Logger LOGGER = LogManager.getLogger(LogoutSuccess.class);

    /**
     * 
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        LOGGER.info(" Enter >> onLogoutSuccess() ");
        if (authentication != null && authentication.getDetails() != null) {
            try {
                request.getSession()
                    .invalidate();
                LOGGER.info("Session invalidated....");
                // you can add more codes here when the user successfully logs
                // out,
                // such as updating the database for last active.
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        response.setStatus(HttpServletResponse.SC_OK);
        LOGGER.info(" Exit << onLogoutSuccess() ");
    }

}
