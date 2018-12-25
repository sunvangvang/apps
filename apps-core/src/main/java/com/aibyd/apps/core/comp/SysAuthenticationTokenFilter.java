package com.aibyd.apps.core.comp;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aibyd.apps.core.bean.SysUserDetails;
import com.aibyd.apps.core.util.JWTTokenUtil;
import com.aibyd.apps.core.util.ResponseUtil;
import com.alibaba.fastjson.JSONObject;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class SysAuthenticationTokenFilter extends OncePerRequestFilter {

    @Resource
    SysUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        String authHeader = request.getHeader("Authentication");

        if (authHeader != null) {
            final String authToken = authHeader;
            String username = "";
            try {
                username = JWTTokenUtil.parseToken(authToken, JWTTokenUtil.keyParsePass);
            } catch (ExpiredJwtException e) {
                JSONObject res = ResponseUtil.fail(501, "授权已过期, 请重新登录!");
                response.getWriter().write(res.toJSONString());
                return;
            }
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                SysUserDetails userDetails = userDetailsService.loadUserByUsername(username);
                if (userDetails != null) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        chain.doFilter(request, response);
    }

}