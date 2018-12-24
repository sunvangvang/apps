package com.aibyd.apps.db.dao;

import com.aibyd.apps.db.Application;

import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SysUserMapperTest {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    public void testUser() {
        long count = sysUserMapper.countByExample(null);
        // for (Map m : result) {
        // m.forEach((k, v) -> System.out.println("key:value = " + k + ":" + v));
        // }
        Assert.assertEquals(1, count);
    }
}
