package com.example.demorabbitmq;

import com.example.demorabbitmq.Dto.UserDetails;
import com.example.demorabbitmq.Utils.ApplicationConstant;
import com.example.demorabbitmq.config.RabbitMQConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class MessageListener {
    private static final Logger log = LoggerFactory.getLogger(MessageListener.class);
    @Autowired
    RabbitMQConfig rabbitMQConfig;

    @RabbitListener(queues = "${app1.queue.name}")
    public void receveMessageForApp1(final UserDetails data) {
        log.info("Received message: {} from app1 queue.", data);
        try {
            log.info("Making REST call to the API");
            //TODO: Code to make REST call
            log.info("<< Exiting receiveMessageForApp1() after API call.");
        } catch (HttpClientErrorException exception) {
            if (exception.getStatusCode() == HttpStatus.NOT_FOUND) {
                log.info("Delay...");
                try {
                    Thread.sleep(ApplicationConstant.MESSAGE_RETRY_DELAY);
                } catch (InterruptedException exception1) {
                }
                log.info("Throwing exception so that message will be requed in the queue.");
                throw new RuntimeException();
            } else {
                throw new AmqpRejectAndDontRequeueException(exception);
            }
        }
    }

    @RabbitListener(queues = "${app2.queue.name}")
    public void receveMessageForApp2(String reqObj) {
        try {
            log.info("Received message: {} from app2 queue.", reqObj);
//        TODO: Code to make REST call
            log.info("<< Exiting receiveMessageCrawlCI() after API call.");
        } catch (HttpClientErrorException ex) {
            if (ex.getStatusCode() == HttpStatus.NOT_FOUND){
                try {
                    Thread.sleep(ApplicationConstant.MESSAGE_RETRY_DELAY);
                }catch (InterruptedException ex1){}
                log.info("Throwing exception so that message will be requed in the queue.");
                // Note: Typically Application specific exception can be thrown below
                throw new RuntimeException();
            }else {
                throw new AmqpRejectAndDontRequeueException(ex);
            }
        }catch (Exception e){
            log.error("Internal server error occurred in python server. Bypassing message requeue {}", e);
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}