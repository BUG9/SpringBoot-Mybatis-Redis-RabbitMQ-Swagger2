package com.springBoot.rabbitMQ;

import com.springBoot.config.RabbitMQConfig;
import com.springBoot.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * Created by jingxian on 2018/1/29.
 */
@Component
@RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
public class Receiver {

    @RabbitHandler
    public void receiveMessage(User user){
        System.out.println("Receiver<" + user.toString() + ">");
    }
}
