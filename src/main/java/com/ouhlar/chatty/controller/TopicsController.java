package com.ouhlar.chatty.controller;

import com.ouhlar.chatty.dto.Topic;
import com.ouhlar.chatty.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicsController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/getAllTopics")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @RequestMapping("/getTopic/{id}")
    public Topic getTopic(@PathVariable long id) {
        return topicService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addTopic/{topicName}")
    public String addUser(@PathVariable String topicName) {
        return topicService.addTopic(topicName);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteTopic/{id}")
    public String deleteTopic(@PathVariable long id) {
        return topicService.deleteTopic(id);
    }
}
