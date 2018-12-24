package com.aibyd.apps.core.config;

import com.aibyd.apps.core.comp.SysAuthenticationEntryPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SysAuthenticationEntryPoint authenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .httpBasic().authenticationEntryPoint(authenticationEntryPoint).and().authorizeRequests()
                .antMatchers("/login").permitAll().anyRequest()
                .access("@sysRbacAuthorityService.hasPermission(request, authentication)").and().rememberMe()
                .tokenValiditySeconds(300);
    }

}