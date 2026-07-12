package com.example.learnKafka.user_service.event;

public record UserCreatedEvent(
        Long id,
        String email
) {
    /** TO successfully deserialize , we need this class in the notification-service, in the matching path
     * else we'll get the below errors, even after adding the path in spring.kafka.consumer.properties.spring.json.trusted.packages
     * <p>
     * java.lang.IllegalStateException
     Caused by : org.apache.kafka.common.errors.RecordDeserializationException : Error deserializing VALUE for partition ...
     Caused by : org.springframework.messaging.converter.MessageConversionException : failed to resolve class name.
                    Class not found [com.example.learnKafka.user_service.event.UserCreatedEvent]
**/
     }
