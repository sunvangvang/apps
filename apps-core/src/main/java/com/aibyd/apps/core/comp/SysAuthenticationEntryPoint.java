package com.aibyd.apps.core.comp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import com.aibyd.apps.core.util.ResponseUtil;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * 未登录时返回JSON格式的数据给前端, 否则为HTML
 */
@Component
public class SysAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
            throws IOException, ServletException {
        response.getWriter().write(ResponseUtil.unlogin().toJSONString());
    }

}