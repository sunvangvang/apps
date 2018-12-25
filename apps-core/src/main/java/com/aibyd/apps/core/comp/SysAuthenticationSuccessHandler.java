package com.aibyd.apps.core.comp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aibyd.apps.core.bean.SysUserDetails;
import com.aibyd.apps.core.util.JWTTokenUtil;
import com.aibyd.apps.core.util.ResponseUtil;
import com.alibaba.fastjson.JSONObject;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * 登录成功返回JSON格式数据给前端
 */
@Component
public class SysAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        SysUserDetails userDetails = (SysUserDetails) authentication.getPrincipal();
        String token = JWTTokenUtil.generateToken(userDetails.getUsername(), 3600, JWTTokenUtil.keyParsePass);
        JSONObject data = new JSONObject();
        data.put("token", token);
        response.getWriter().write(ResponseUtil.ok(data).toJSONString());
    }

}