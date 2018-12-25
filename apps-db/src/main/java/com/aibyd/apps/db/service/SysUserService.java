package com.aibyd.apps.db.service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

import com.aibyd.apps.db.dao.SysUserMapper;
import com.aibyd.apps.db.domain.SysUser;
import com.aibyd.apps.db.domain.SysUserExample;

import org.springframework.stereotype.Service;

@Service
public class SysUserService {

    @Resource
    private SysUserMapper userMapper;

    public SysUser findById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public int add(SysUser user) {
        user.setCreateTime(LocalDateTime.now());
        return userMapper.insertSelective(user);
    }

    public List<SysUser> queryByUserName(String userName) {
        SysUserExample example = new SysUserExample();
        example.or().andUserNameEqualTo(userName);
        return userMapper.selectByExample(example);
    }

}