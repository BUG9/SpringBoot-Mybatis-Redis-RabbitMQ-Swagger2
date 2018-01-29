package com.springBoot;

import com.springBoot.rabbitMQ.Receiver;
import com.springBoot.rabbitMQ.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by jingxian on 2018/1/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class rabbitMQTest {

    @Autowired
    private Sender sender;

    @Test
    public void send(){
        sender.send();
    }
}
