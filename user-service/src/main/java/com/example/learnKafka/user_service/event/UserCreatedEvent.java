package com.example.learnKafka.user_service.event;

import com.example.learnKafka.user_service.entity.User;

public record UserCreatedEvent(
        Long id,
        String email
) {
    public static UserCreatedEvent of(User user){
        return new UserCreatedEvent(user.getId(),user.getEmail());
    }
}
