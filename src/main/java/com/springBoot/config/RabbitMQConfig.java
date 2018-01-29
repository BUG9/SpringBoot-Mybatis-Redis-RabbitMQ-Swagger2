package com.springBoot.config;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jingxian on 2018/1/29.
 */
@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE   = "spring-boot-exchange";

    public static final String ROUTINGKEY = "spring-boot-routingKey";

    public static final String QUEUE_NAME = "spring-boot-routingKey";





    /**
     * 针对消费者配置
     * 1. 设置交换机类型
     * 2. 将队列绑定到交换机
     *
     *
     FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
     HeadersExchange ：通过添加属性key-value匹配
     DirectExchange:按照routingkey分发到指定队列
     TopicExchange:多关键字匹配
     */
    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Queue queue() {
        // 是否持久化
        boolean durable = true;
        // 仅创建者可以使用的私有队列，断开后自动删除
        boolean exclusive = false;
        // 当所有消费客户端连接断开后，是否自动删除队列
        boolean autoDelete = false;
        return new Queue(QUEUE_NAME, durable,exclusive,autoDelete); //队列持久

    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(defaultExchange()).with(RabbitMQConfig.ROUTINGKEY);
    }

//    //有了上面的配置基本上就可以应对多模式下的rabbitMQ，如果需要手工配置其他，可继续以下Bean构造
//    //下面2个Bean分别对应是否使用@RabbitListener和@RabbitHandler，没有使用可用以下来配置
//    @Bean
//    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
//                                             MessageListenerAdapter listenerAdapter) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setQueueNames(QUEUE_NAME);
//        container.setMessageListener(listenerAdapter);
//        return container;
//    }
//
//    //监听消息消费者，并设置消息处理方法
//    @Bean
//    MessageListenerAdapter listenerAdapter(Receiver receiver) {
//        return new MessageListenerAdapter(receiver, "receiveMessage");
//    }

//    //这个Bean对应手工应答机制
//    @Bean
//    public SimpleMessageListenerContainer messageContainer(ConnectionFactory connectionFactory) { //使用SpringBoot默然的connectionFactory
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
//        container.setQueues(queue());
//        container.setExposeListenerChannel(true);
//        container.setMaxConcurrentConsumers(1);
//        container.setConcurrentConsumers(1);
//        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
//        container.setMessageListener(new ChannelAwareMessageListener() {
//
//            @Override
//            public void onMessage(Message message, Channel channel) throws Exception {
//                byte[] body = message.getBody();
//                System.out.println("receive msg : " + new String(body));
//                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false); //确认消息成功消费
//            }
//        });
//        return container;
//    }
}
