package com.example.demorabbitmq.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@Getter
@Setter
@NoArgsConstructor
public class RabbitMQConfig {
    @Value("${app1.exchange.name}")
    private String app1Exchange;
    @Value("${app1.queue.name}")
    private String app1Queue;
    @Value("${app1.routing.key}")
    private String app1Routingkey;
    @Value("${app2.exchange.name}")
    private String app2Exchange;
    @Value("${app2.queue.name}")
    private String app2Queue;
    @Value("${app2.routing.key}")
    private String app2Routingkey;
}
