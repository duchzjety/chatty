package com.ouhlar.chatty.controller;


import com.ouhlar.chatty.dto.User;
import com.ouhlar.chatty.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class UsersController {


    @Autowired
    private UserService userService;

    @RequestMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping("/getUser/{id}")
    public User getuser(@PathVariable long id) {
        return userService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addUser/{userName}")
    public String addUser(@PathVariable String userName) {
        return userService.addUser(userName);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteUser/{id}")
    public String deleteUser(@PathVariable long id) {
        return userService.deleteUser(id);
    }
}
