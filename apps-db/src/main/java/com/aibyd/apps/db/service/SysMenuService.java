package com.aibyd.apps.db.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import com.aibyd.apps.db.dao.SysMenuMapper;
import com.aibyd.apps.db.dao.SysMenuRoleMapper;
import com.aibyd.apps.db.domain.SysMenu;
import com.aibyd.apps.db.domain.SysMenuExample;
import com.aibyd.apps.db.domain.SysMenuRole;
import com.aibyd.apps.db.domain.SysMenuRoleExample;

import org.springframework.stereotype.Service;

@Service
public class SysMenuService {

    @Resource
    private SysMenuMapper menuMapper;

    public Integer findMenuIdByUri(String uri) {
        SysMenuExample example = new SysMenuExample();
        example.or().andPageUrlEqualTo(uri);
        List<SysMenu> menus = menuMapper.selectByExample(example);
        if (menus != null && menus.size() == 1) {
            return menus.get(0).getId();
        }
        return -1;
    }

}