package com.example.learnKafka.user_service.controller;

import com.example.learnKafka.user_service.dto.CreateUserRequestDto;
import com.example.learnKafka.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

    @Value("${kafka.topic.user-random-topic}")
    private String KAFKA_USER_RANDOM_TOPIC;
    private final KafkaTemplate<String,String> kafkaTemplate;

    private final UserService userService;

    @PostMapping("/{message}")
    public ResponseEntity<String> sendMessage(@PathVariable String message){

        for(int i=1; i<=1000; i++) {
            kafkaTemplate.send(KAFKA_USER_RANDOM_TOPIC, String.valueOf(i%3), message+" "+i);
        }
        return ResponseEntity.ok("Message queued");
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequestDto userRequestDto){
        userService.createUser(userRequestDto);
        return ResponseEntity.ok("User is created with name "+ userRequestDto.fullName());
    }
}
