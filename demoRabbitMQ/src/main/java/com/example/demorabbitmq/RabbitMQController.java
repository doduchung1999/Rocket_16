package com.example.demorabbitmq;

import com.example.demorabbitmq.Dto.UserDetails;
import com.example.demorabbitmq.Utils.ApplicationConstant;
import com.example.demorabbitmq.config.RabbitMQConfig;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/rabbit")
@Getter
public class RabbitMQController {
    private static final Logger log = LoggerFactory.getLogger(RabbitMQController.class);
    private final RabbitTemplate rabbitTemplate;
    private RabbitMQConfig rabbitMQConfig;
    private MessageSender messageSender;

    @Autowired
    public RabbitMQController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Autowired
    public void setRabbitMQConfig(RabbitMQConfig rabbitMQConfig) {
        this.rabbitMQConfig = rabbitMQConfig;
    }

    @Autowired
    public void setMessageSender(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sendMessage(@RequestBody UserDetails user) {
        String exchange = getRabbitMQConfig().getApp1Exchange();
        String routingKey = getRabbitMQConfig().getApp1Routingkey();
        try {
            messageSender.sendMessage(rabbitTemplate, exchange, routingKey, user);
            return new ResponseEntity<String>(ApplicationConstant.IN_QUEUE, HttpStatus.OK);
        } catch (Exception exception) {
            log.error("Exception occurred while sending message to the queue. Exception= {}", exception);
            return new ResponseEntity(ApplicationConstant.MESSAGE_QUEUE_SEND_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
