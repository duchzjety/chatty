package com.ouhlar.chatty.storage;

import java.util.HashSet;
import java.util.Set;

public class RegisteredUsers {

    private static RegisteredUsers instance;
    private Set<String> users;

    private RegisteredUsers() {
        users = new HashSet<>();
    }

    public static synchronized RegisteredUsers getInstance() {
        if (instance == null) {
            instance = new RegisteredUsers();
        }
        return instance;
    }

    public Set<String> getUsers() {
        return users;
    }

    public void setUser(String userName) throws Exception {
        if (users.contains(userName)) {
            throw new Exception("User already exists with username: " + userName);
        }
        users.add(userName);
    }
}
