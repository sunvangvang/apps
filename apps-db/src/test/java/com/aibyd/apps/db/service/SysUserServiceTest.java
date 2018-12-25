package com.aibyd.apps.db.service;

import java.util.List;

import com.aibyd.apps.db.Application;
import com.aibyd.apps.db.domain.SysUser;

import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SysUserServiceTest {

    @Autowired
    private SysUserService sysUserService;

    @Test
    public void testFindById() {
        SysUser user = sysUserService.findById(33);
        Assert.assertNotNull(user);
        Assert.assertEquals("admin", user.getUserName());
    }

    @Test
    public void testAdd() {
        SysUser user = new SysUser();
        user.setUserName("junitTest");
        user.setPasswd("junitTest");
        user.setValid("1");
        int res = sysUserService.add(user);
        Assert.assertEquals(1, res);
    }

    @Test
    public void testQueryByUserName() {
        List<SysUser> users = sysUserService.queryByUserName("admin");
        int i = users.size();
        Assert.assertEquals(1, i);
    }

}
