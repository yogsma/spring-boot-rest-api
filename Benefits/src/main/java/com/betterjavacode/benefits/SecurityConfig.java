package com.betterjavacode.benefits;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@ComponentScan("com.betterjavacode.benefits.services")
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static final Logger LOGGER = LogManager.getLogger(SecurityConfig.class);

    @Autowired
    private SimpleAuthenticationSuccessHandler loginSuccess;

    @Autowired
    private LogoutSuccess logoutSuccess;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DataSource dataSource;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        LOGGER.info(" Enter >> configureGlobal() ");
        auth.jdbcAuthentication()
            .usersByUsernameQuery("select email,password_hash,enabled from user where email=?")
            .authoritiesByUsernameQuery("select u.email,r.role from user u inner join user_role ur on(u.id=ur.user_id) inner join role r on(r.id=ur.role_id) where u.email=?")
            .dataSource(dataSource)
            .passwordEncoder(bCryptPasswordEncoder);
        LOGGER.info(" Exit << configureGlobal() ");
    }

    /**
     * Handle Login - Authentication and Redirection
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /* http.csrf()
            .disable()
            .authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
            .logout()
            .permitAll(); */

        /*http.csrf()
            .disable() */
        http.authorizeRequests()
            .antMatchers("/home")
            .hasAuthority("ADMIN")
            .antMatchers("/user")
            .hasAnyAuthority("USER", "ADMIN")
            .and()
            .formLogin()
            .loginPage("/login")
            .successHandler(loginSuccess)
            .permitAll()
            .and()
            .logout()
            .logoutSuccessHandler(logoutSuccess)
            .deleteCookies("JSESSIONID")
            .invalidateHttpSession(false)
            .permitAll()
            .and()
            .exceptionHandling()
            .accessDeniedPage("/403")
            .and()
            .csrf()
            .csrfTokenRepository(csrfTokenRepository())
            .and()
            .addFilterAfter(new CSRFHeaderFilter(), CsrfFilter.class);

    }

    private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("X-XSRF-TOKEN");
        return repository;
    }

    /**
     * Exclude resources from user-access
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
            .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }
}
