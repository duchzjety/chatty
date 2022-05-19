package com.ouhlar.chatty.controller;

import com.ouhlar.chatty.dto.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat/private/{to}")
    public void sendPrivateMessage(@DestinationVariable String to, MessageDto message) {
        System.out.println("handling send message: " + message + " to: " + to);
        simpMessagingTemplate.convertAndSend("/topic/messages/" + to, message);
    }

    @MessageMapping("/chat/public/{topic}")
    public void sendPublicMessage(@DestinationVariable String topic, MessageDto message) {
        System.out.println("handling send message: " + message + " to: " + topic);
        simpMessagingTemplate.convertAndSend("/topic/messages/" + topic, message);
    }
}
