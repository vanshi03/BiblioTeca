package com.example.BiblioTeca.model;

import java.util.Objects;

public class User {
    private String id;
    private String name;

    public User() {
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        User user = (User)obj;
        if(this.id.equalsIgnoreCase(user.id))
            return true;
        return false;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
