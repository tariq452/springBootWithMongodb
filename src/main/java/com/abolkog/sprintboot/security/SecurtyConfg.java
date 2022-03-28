package com.abolkog.sprintboot.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
public class SecurtyConfg extends WebSecurityConfigurerAdapter {
    private final String[] PUBLIC_ENDPOINTS={
            "/api/v1/auth/**"
    };
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
               .cors().and().csrf().disable()
               .sessionManagement()
               .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
               .and()
               .authorizeRequests()
               .antMatchers(PUBLIC_ENDPOINTS).permitAll()
               .anyRequest().authenticated()
                .and()
                .httpBasic();
    }
}
