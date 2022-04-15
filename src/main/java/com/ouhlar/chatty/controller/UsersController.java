package com.ouhlar.chatty.controller;

import com.ouhlar.chatty.storage.RegisteredUsers;
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
public class UsersController {

    private final static Logger LOGGER = LoggerFactory.getLogger(UsersController.class);

    @GetMapping("/registration/{userName}")
    public ResponseEntity<Void> register(@PathVariable String userName) {
        LOGGER.info("handling register user request: " + userName);
        try {
            RegisteredUsers.getInstance().setUser(userName);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getAllUsers")
    public Set<String> getAllUsers() {
        return RegisteredUsers.getInstance().getUsers();
    }
}
