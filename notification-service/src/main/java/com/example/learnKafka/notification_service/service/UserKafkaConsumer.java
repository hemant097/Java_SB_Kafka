package com.example.learnKafka.notification_service.service;

import com.example.learnKafka.user_service.event.UserCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserKafkaConsumer {

    @KafkaListener(topics = "user-created-topic")
    public void handlerUserCreated(UserCreatedEvent userCreatedEvent){
        log.info("New user created in handleUserCreated with email: {}",userCreatedEvent.email());
    }

    @KafkaListener(topics = "user-random-topic")
    public void handlerUserRandomTopic1(String message){
       log.info("Message received in handlerUserRandomTopic1: {}",message);
    }

    @KafkaListener(topics = "user-random-topic")
    public void handlerUserRandomTopic2(String message){
        log.info("Message received in handlerUserRandomTopic2: {}",message);
    }

    @KafkaListener(topics = "user-random-topic")
    public void handlerUserRandomTopic3(String message){
        log.info("Message received in handlerUserRandomTopic3: {}",message);
    }

}
