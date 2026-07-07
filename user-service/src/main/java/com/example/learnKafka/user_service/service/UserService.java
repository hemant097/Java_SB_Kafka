package com.example.learnKafka.user_service.service;

import com.example.learnKafka.user_service.dto.CreateUserRequestDto;
import com.example.learnKafka.user_service.entity.User;
import com.example.learnKafka.user_service.event.UserCreatedEvent;
import com.example.learnKafka.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    @Value("${kafka.topic.user-created-topic}")
    private String KAFKA_USER_CREATED_TOPIC;

    private final UserRepository userRepository;
    private final KafkaTemplate<Long,UserCreatedEvent> kafkaTemplate;

    public void createUser(CreateUserRequestDto userRequestDto){
        User savedUser = userRepository.save(User.of(userRequestDto));
        log.info("User with name: {} is saved in DB with id: {}",savedUser.getName(), savedUser.getId());

        UserCreatedEvent userCreatedEvent = UserCreatedEvent.of(savedUser);
        kafkaTemplate.send(KAFKA_USER_CREATED_TOPIC,userCreatedEvent.id(),userCreatedEvent);
    }
}
