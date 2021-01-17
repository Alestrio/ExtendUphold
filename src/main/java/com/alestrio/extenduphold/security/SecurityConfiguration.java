package com.alestrio.extenduphold.security;

import com.alestrio.extenduphold.data.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;


@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String LOGIN_PROCESSING_URL = "/login";
    private static final String LOGIN_FAILURE_URL = "/login?error";
    private static final String LOGIN_URL = "/login";
    private static final String LOGOUT_SUCCESS_URL = "/login";


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * method to block unauthenticated requests to all pages, except the login page.
         */
        http.csrf().disable()
                .requestCache().requestCache(new CustomRequestCache())
                .and().authorizeRequests()
                .requestMatchers(SecurityUtils::isFrameworkInternalRequest).permitAll()

                .anyRequest().authenticated()

                .and().formLogin()
                .loginPage(LOGIN_URL).permitAll()
                .loginProcessingUrl(LOGIN_PROCESSING_URL)
                .failureUrl(LOGIN_FAILURE_URL)
                .and().logout().logoutSuccessUrl(LOGOUT_SUCCESS_URL);
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        /**
         * Defines a single user with the username "user" and password "password" in an in-memory DetailsManager.
         * We do not recommend that you configure users directly in the code for applications in production.
         * You can easily change this Spring Security configuration to use an authentication provider for
         * LDAP, JAAS, and other real world sources.
         *
         * Personal note : This is the function returning an array of UserDetails, which means it is pretty easy to
         * modify and link the SpringSecurity to our database.
         * Though, we will surely have to edit the password-hashing function to use Spring Security library.
         * https://mkyong.com/spring-security/spring-security-password-hashing-example/
         *
         * Additionally, there is currently no admin GUI, so there is no need to use another role than USER.
         * We will edit that when Admin GUI starts to be WiP.
         */
        ArrayList<UserDetails> details = new ArrayList<>();
        List<com.alestrio.extenduphold.data.entity.User> users = new UserService().findAll();
        users.forEach(e -> {
            details.add(User
                    .withUsername(e.getUsername())
                    .password(e.getPassword())
                    .roles("USER")
                    .build()
            );
        });

        return new InMemoryUserDetailsManager(details);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

    @Override
    public void configure(WebSecurity web) {
        /**
         * Excludes Vaadin-framework communication and static assets from Spring Security.
         */
        web.ignoring().antMatchers(
                "/VAADIN/**",
                "/favicon.ico",
                "/robots.txt",
                "/manifest.webmanifest",
                "/sw.js",
                "/offline.html",
                "/icons/**",
                "/images/**",
                "/styles/**",
                "/h2-console/**",
                "/register/**");
    }
}
