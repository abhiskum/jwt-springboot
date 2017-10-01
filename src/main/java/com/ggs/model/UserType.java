package com.ggs.model;

/**
 * Created by abhiskum on 8/29/17.
 */
public enum UserType {

    AdminUser("Admin"), User("User");

    private String type;

    private UserType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
