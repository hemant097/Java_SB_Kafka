package com.example.learnKafka.notification_service.service;

import com.example.learnKafka.event.UserCreatedEvent;
import com.example.learnKafka.notification_service.entity.SavedTime;
import com.example.learnKafka.notification_service.repo.SavedTimeRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserKafkaConsumer {

    private final SavedTimeRepo savedTimeRepo;

    @KafkaListener(topics = "user-created-topic")
    public void handlerUserCreated(UserCreatedEvent userCreatedEvent){
        log.info("New user created in handleUserCreated with email: {}",userCreatedEvent.getEmail());

        SavedTime savedTime = new SavedTime();
        savedTime.setEmail(String.valueOf(userCreatedEvent.getEmail()));
        savedTime.setSavedAt(LocalDateTime.now());
        savedTimeRepo.save(savedTime);
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
