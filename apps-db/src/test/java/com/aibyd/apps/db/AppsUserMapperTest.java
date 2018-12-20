package com.aibyd.apps.db;

import org.junit.Test;
import org.junit.runner.RunWith;
// import org.linlinjava.litemall.db.dao.StatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import junit.framework.Assert;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import com.aibyd.apps.db.dao.AppsUserMapper;

// @WebAppConfiguration
// @RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppsUserMapperTest {

    @Autowired
    private AppsUserMapper appsUserMapper;

    @Test
    public void testUser() {
        long count = appsUserMapper.countByExample(null);
        // for (Map m : result) {
        //     m.forEach((k, v) -> System.out.println("key:value = " + k + ":" + v));
        // }
        assertEquals(1, count);
    }
}
