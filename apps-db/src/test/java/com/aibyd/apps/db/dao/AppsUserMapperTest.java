package com.aibyd.apps.db.dao;

import com.aibyd.apps.db.Application;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AppsUserMapperTest {

    @Autowired
    private AppsUserMapper appsUserMapper;

    @Test
    public void testUser() {
        long count = appsUserMapper.countByExample(null);
        // for (Map m : result) {
        // m.forEach((k, v) -> System.out.println("key:value = " + k + ":" + v));
        // }
        assertEquals(1, count);
    }
}
