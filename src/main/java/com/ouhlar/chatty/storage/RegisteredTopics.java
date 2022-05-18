package com.ouhlar.chatty.storage;

import com.ouhlar.chatty.dto.Topic;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RegisteredTopics extends JpaRepository<Topic, Long> {
}
