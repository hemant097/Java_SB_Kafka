package com.example.learnKafka.user_service.entity;

import com.example.learnKafka.user_service.dto.CreateUserRequestDto;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "app_users")
public class User {

    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String email;
    String fullName;

    public static User of(CreateUserRequestDto dto){
        User user = new User();
        user.setEmail(dto.email());
        user.setFullName(dto.fullName());
        return user;
    }
}
