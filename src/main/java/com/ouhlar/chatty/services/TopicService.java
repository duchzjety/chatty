package com.ouhlar.chatty.services;

import com.ouhlar.chatty.dto.Topic;
import com.ouhlar.chatty.exceptions.TopicNotFoundException;
import com.ouhlar.chatty.storage.RegisteredTopics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    @Autowired
    RegisteredTopics registeredTopics;
    public List<Topic> getAllTopics() {
        return registeredTopics.findAll();
    }

    public Topic getTopic(long id){
        return registeredTopics.findById(id).orElseThrow(
                ()->new TopicNotFoundException("Topic with id" + id + "not found"));
    }

    public String addTopic(String topicName) {
        Topic newTopic = new Topic();
        newTopic.setTopic(topicName);
        registeredTopics.save(newTopic);
        return "Topic " + newTopic.getTopic() + " successfuly added";
    }

    public String deleteTopic(long id) {
        registeredTopics.deleteById(id);
        return "Topic with id" + id + " was deleted";
    }
}
