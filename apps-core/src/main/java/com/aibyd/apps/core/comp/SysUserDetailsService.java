package com.aibyd.apps.core.comp;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

import javax.annotation.Resource;

import com.aibyd.apps.db.domain.SysUser;
import com.aibyd.apps.core.bean.SysUserDetails;
import com.aibyd.apps.db.service.SysRoleService;
import com.aibyd.apps.db.service.SysUserService;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class SysUserDetailsService implements UserDetailsService {

    @Resource
    private SysUserService userService;

    @Resource
    private SysRoleService roleService;

    @Override
    public SysUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUserDetails userDetails = new SysUserDetails();
        List<SysUser> users = userService.queryByUserName(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
        if (users == null || users.size() != 1) {
            throw new UsernameNotFoundException("username :" + username + " not found!");
        } else {
            SysUser user = users.get(0);
            Set<Integer> roleIdSet = roleService.queryRoleIdsByUserId(user.getId());
            if (roleIdSet != null && roleIdSet.size() > 0) {
                for (Integer roleId : roleIdSet) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(String.valueOf(roleId));
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            userDetails.setUsername(user.getUserName());
            userDetails.setPassword(user.getPasswd());
            userDetails.setAuthorities(grantedAuthorities);
        }
        return userDetails;
    }

}