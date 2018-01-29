package com.springBoot.rabbitMQ;

import com.springBoot.config.RabbitMQConfig;
import com.springBoot.mapper.UserMapper;
import com.springBoot.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by jingxian on 2018/1/29.
 */
@Component
public class Sender {

    @Resource
    private AmqpTemplate amqpTemplate;

    @Resource
    private UserMapper userMapper;

    public void send(){

        User user = userMapper.findById(1L);
        System.out.println("Send:" + user.toString());
        this.amqpTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME,user);
    }
}
