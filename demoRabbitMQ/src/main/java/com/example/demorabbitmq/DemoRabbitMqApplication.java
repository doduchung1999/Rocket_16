package com.example.demorabbitmq;

import com.example.demorabbitmq.config.RabbitMQConfig;
import lombok.Getter;
import lombok.Setter;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

@EnableRabbit
@SpringBootApplication
@Getter
@Setter
public class DemoRabbitMqApplication extends SpringBootServletInitializer implements RabbitListenerConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(DemoRabbitMqApplication.class, args);
    }

    @Autowired
    private RabbitMQConfig rabbitMQConfig;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DemoRabbitMqApplication.class);
    }

    @Bean
    public RabbitMQConfig rabbitMQConfig(){
        return new RabbitMQConfig();
    }

    @Bean
    public TopicExchange getApp1Exchange(){
        return new TopicExchange(rabbitMQConfig().getApp1Exchange());
    }

    @Bean
    public Queue getApp1Queue(){
        return new Queue(getRabbitMQConfig().getApp1Queue());
    }

    @Bean
    public Binding declareBindingApp1(){
        return BindingBuilder.bind(getApp1Queue()).to(getApp1Exchange()).with(getRabbitMQConfig().getApp1Routingkey());
    }

    @Bean
    public TopicExchange getApp2Exchange(){
        return new TopicExchange(rabbitMQConfig.getApp2Exchange());
    }

    @Bean
    public Queue getApp2Queue(){
        return new Queue(getRabbitMQConfig().getApp2Queue());
    }

    @Bean
    public Binding declareBindingApp2(){
        return BindingBuilder.bind(getApp2Queue()).to(getApp2Exchange()).with(getRabbitMQConfig().getApp2Routingkey());
    }

    @Bean /* Rabbit template*/
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory){
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }
    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public MappingJackson2MessageConverter consumerJackson2MessageConverter(){
        return new MappingJackson2MessageConverter();
    }

    @Bean
    public DefaultMessageHandlerMethodFactory messageHandlerMethodFactory(){
        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
        factory.setMessageConverter(consumerJackson2MessageConverter());
        return factory;
    }

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {

    }
}
