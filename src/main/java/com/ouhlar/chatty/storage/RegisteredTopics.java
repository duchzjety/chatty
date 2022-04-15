package com.ouhlar.chatty.storage;

import java.util.HashSet;
import java.util.Set;

public class RegisteredTopics {

    private static RegisteredTopics instance;
    private Set<String> topics;

    private RegisteredTopics() {
        topics = new HashSet<>();
    }

    public static synchronized RegisteredTopics getInstance() {
        if (instance == null) {
            instance = new RegisteredTopics();
        }
        return instance;
    }

    public Set<String> getTopics() {
        return topics;
    }

    public void setTopic(String topicName) throws Exception {
        if (topics.contains(topicName)) {
            throw new Exception("Topic already exists with topic name: " + topicName);
        }
        topics.add(topicName);
    }
}
