package com.aibyd.apps.core.config;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.aibyd.apps.core.comp.SysAccessDeniedHandler;
import com.aibyd.apps.core.comp.SysAuthenticationEntryPoint;
import com.aibyd.apps.core.comp.SysAuthenticationFailureHandler;
import com.aibyd.apps.core.comp.SysAuthenticationSuccessHandler;
import com.aibyd.apps.core.comp.SysAuthenticationTokenFilter;
import com.aibyd.apps.core.comp.SysLogoutHandler;
import com.aibyd.apps.core.comp.SysLogoutSuccessHandler;
import com.aibyd.apps.core.comp.SysUserDetailsService;
import com.aibyd.apps.core.util.MD5Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class CustomWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private SysAuthenticationEntryPoint authenticationEntryPoint;

    @Resource
    private SysAuthenticationSuccessHandler authenticationSuccessHandler;

    @Resource
    private SysAuthenticationFailureHandler authenticationFailureHandler;

    @Resource
    private SysAccessDeniedHandler accessDeniedHandler;

    @Resource
    private SysLogoutHandler logoutHandler;

    @Resource
    private SysLogoutSuccessHandler logoutSuccessHandler;

    @Resource
    private SysAuthenticationTokenFilter authenticationTokenFilter;

    @Resource
    private SysUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .httpBasic().authenticationEntryPoint(authenticationEntryPoint).and().authorizeRequests()
                .antMatchers("/auth").permitAll().anyRequest()
                .access("@sysRABCHandler.hasPermission(request, authentication)").and().formLogin()
                .successHandler(authenticationSuccessHandler).failureHandler(authenticationFailureHandler).permitAll()
                .loginProcessingUrl("/auth").usernameParameter("username").passwordParameter("password").and().headers()
                .frameOptions().sameOrigin().and().logout().addLogoutHandler(logoutHandler)
                .logoutSuccessHandler(logoutSuccessHandler).and()

                .rememberMe().tokenValiditySeconds(300).and().exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint).accessDeniedHandler(accessDeniedHandler).and()
                .addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new PasswordEncoder() {

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return encodedPassword.equals(MD5Util.encode((String) rawPassword));
            }

            @Override
            public String encode(CharSequence rawPassword) {
                return MD5Util.encode((String) rawPassword);
            }
        });
    }

    @Bean
    public PasswordEncoder md5PasswordEncoder() {
        return new PasswordEncoder() {

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return encodedPassword.equals(MD5Util.encode((String) rawPassword));
            }

            @Override
            public String encode(CharSequence rawPassword) {
                return MD5Util.encode((String) rawPassword);
            }
        };
    }

}