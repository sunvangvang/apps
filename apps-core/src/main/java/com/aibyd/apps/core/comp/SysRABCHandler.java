package com.aibyd.apps.core.comp;

import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.aibyd.apps.db.service.SysMenuService;
import com.aibyd.apps.db.service.SysRoleService;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component("sysRABCHandler")
public class SysRABCHandler {

    @Resource
    SysMenuService menuService;

    @Resource
    SysRoleService roleService;

    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object userDetails = authentication.getPrincipal();
        boolean hasPermission = false;

        String uri = request.getRequestURI();
        Integer menuId = menuService.findMenuIdByUri(uri);
        Set<Integer> roleIdSet = roleService.queryRoleIdsByMenuId(menuId);
        if (userDetails instanceof UserDetails) {
            for (GrantedAuthority ga : authentication.getAuthorities()) {
                if ("ROLE_ANONYMOUS".equals(ga.getAuthority())) {
                    continue;
                }
                Integer roleId = Integer.parseInt(ga.getAuthority());
                if (roleIdSet != null) {
                    if (roleIdSet.contains(roleId)) {
                        hasPermission = true;
                    }
                }
            }
        }
        return hasPermission;
    }
}