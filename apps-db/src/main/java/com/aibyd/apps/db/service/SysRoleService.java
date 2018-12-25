package com.aibyd.apps.db.service;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

import javax.annotation.Resource;

import com.aibyd.apps.db.dao.SysRoleMapper;
import com.aibyd.apps.db.dao.SysUserRoleMapper;
import com.aibyd.apps.db.dao.SysMenuRoleMapper;
import com.aibyd.apps.db.domain.SysMenuRole;
import com.aibyd.apps.db.domain.SysMenuRoleExample;
import com.aibyd.apps.db.domain.SysUserRole;
import com.aibyd.apps.db.domain.SysUserRoleExample;

import org.springframework.stereotype.Service;

@Service
public class SysRoleService {

    @Resource
    private SysRoleMapper roleMapper;

    @Resource
    private SysMenuRoleMapper menuRoleMapper;

    @Resource
    private SysUserRoleMapper userRoleMapper;

    public Set<Integer> queryRoleIdsByUserId(int userId) {
        Set<Integer> roleIds = new HashSet<Integer>();
        SysUserRoleExample example = new SysUserRoleExample();
        example.or().andSysUserIdEqualTo(userId);
        List<SysUserRole> userRoles = userRoleMapper.selectByExample(example);
        if (userRoles != null && userRoles.size() > 0) {
            for (SysUserRole userRole : userRoles) {
                roleIds.add(userRole.getSysRoleId());
            }
        }
        return roleIds;
    }

    public Set<Integer> queryRoleIdsByMenuId(int menuId) {
        Set<Integer> roleIds = new HashSet<Integer>();
        SysMenuRoleExample example = new SysMenuRoleExample();
        example.or().andSysMenuIdEqualTo(menuId);
        List<SysMenuRole> menuRoles = menuRoleMapper.selectByExample(example);
        if (menuRoles != null && menuRoles.size() > 0) {
            for (SysMenuRole menuRole : menuRoles) {
                roleIds.add(menuRole.getSysRoleId());
            }
        }
        return roleIds;
    }

}