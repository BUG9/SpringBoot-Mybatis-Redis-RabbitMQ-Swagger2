package com.springBoot.service.impl;

import com.springBoot.mapper.UserMapper;
import com.springBoot.model.User;
import com.springBoot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by jingxian on 2018/1/29.
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisTemplate<String,User> redisTemplate;


    @Override
    public User findById(Long id) {

        String key = id.toString();

        ValueOperations<String,User> operations = redisTemplate.opsForValue();

        Boolean hasKey = redisTemplate.hasKey(key);
        //缓存存在
        if (hasKey){
            User user = operations.get(key);
            logger.info("从缓存中获取：" + user.toString());
            return user;
        }
        //从OB中获取
        User user = userMapper.findById(id);

        //插入缓存
        operations.set( id.toString(), user,10, TimeUnit.SECONDS);
        logger.info("插入缓存：" + user.toString());

        return user;
    }
}
