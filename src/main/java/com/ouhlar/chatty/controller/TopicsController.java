package com.ouhlar.chatty.controller;

import com.ouhlar.chatty.storage.RegisteredTopics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@CrossOrigin
public class TopicsController {

    private final static Logger LOGGER = LoggerFactory.getLogger(TopicsController.class);

    @GetMapping("/create-topic/{topicName}")
    public ResponseEntity<Void> register(@PathVariable String topicName) {
        LOGGER.info("handling creating topic request: " + topicName);
        try {
            RegisteredTopics.getInstance().setTopic(topicName);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getAllTopics")
    public Set<String> getAllTopics() {
        return RegisteredTopics.getInstance().getTopics();
    }
}
