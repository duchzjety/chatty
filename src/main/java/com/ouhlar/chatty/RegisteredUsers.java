package com.ouhlar.chatty;

import java.util.HashSet;
import java.util.Set;

public class RegisteredUsers {
    private static RegisteredUsers instance;
    private Set<String> users;

    private RegisteredUsers() {
        users = new HashSet<>();
    }

    public static synchronized RegisteredUsers getInstance(){
        if(instance == null){
            instance = new RegisteredUsers();
        }
        return instance;
    }

    public Set<String> getUsers() {
        return users;
    }

    public void setUser(String name) throws Exception{
        if(users.contains(name)){
            throw new Exception("Pouzivatelske meno uz existuje: " + name);
        }
        users.add(name);
    }
}
