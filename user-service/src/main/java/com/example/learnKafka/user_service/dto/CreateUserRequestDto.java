package com.example.learnKafka.user_service.dto;

public record CreateUserRequestDto(
        String email,
        String fullName
) {
}
