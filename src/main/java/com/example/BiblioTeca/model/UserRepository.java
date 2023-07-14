package com.example.BiblioTeca.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {
    private List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
        users.add(new User("1", "Saurabh"));
        users.add(new User("2", "Anjali"));
        users.add(new User("3", "Sakshi"));
        users.add(new User("4", "Vanshi"));
        users.add(new User("5", "Nancy"));
    }

    public List<User> getUsers() {
        return users;
    }
}
