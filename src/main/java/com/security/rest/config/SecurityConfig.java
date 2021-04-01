package com.security.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication().
                withUser("user")
                .password("userpassword")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("userpassword")
                .roles("ADMIN");

    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable().httpBasic().and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/employees/**").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.POST, "/employees/**").hasRole("ADMIN");

    }
}