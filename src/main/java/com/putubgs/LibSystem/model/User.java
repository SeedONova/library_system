package com.putubgs.LibSystem.model;

public class User {
    private String userId;
    private String name;

    public User(String userId, String name){
        this.userId = userId;
        this.name = name;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("User { %s, %s }", userId, name);
    }
}
