package com.example.learnKafka.notification_service.repo;

import com.example.learnKafka.notification_service.entity.SavedTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavedTimeRepo extends JpaRepository<SavedTime,Long> {
}
