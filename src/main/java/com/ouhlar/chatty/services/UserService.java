package com.ouhlar.chatty.services;


import com.ouhlar.chatty.dto.User;
import com.ouhlar.chatty.exceptions.UserNotFoundException;
import com.ouhlar.chatty.storage.RegisteredUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    RegisteredUsers registeredUsers;
    public List<User> getAllUsers() {
        return registeredUsers.findAll();
    }

    public User getUser(long id){
        return registeredUsers.findById(id).orElseThrow(()->new UserNotFoundException("User with id" + id + "not found"));
    }

    public String addUser(String userName) {
        User new_user = new User();
        new_user.setName(userName);
        registeredUsers.save(new_user);
        return "User " + new_user.getName() + " successfuly added";
    }

    public String deleteUser(long id) {
        registeredUsers.deleteById(id);
        return "User with id" + id + " was deleted";
    }
}
