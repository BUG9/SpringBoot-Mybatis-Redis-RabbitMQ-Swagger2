package com.springBoot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by jingxian on 2018/1/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //测试是否能够成功访问redis
    @Test
    public void test(){

        stringRedisTemplate.opsForValue().set("测试","111");

        Assert.assertEquals("111",stringRedisTemplate.opsForValue().get("测试"));
        System.out.println(stringRedisTemplate.opsForValue().get("测试"));
    }
}
