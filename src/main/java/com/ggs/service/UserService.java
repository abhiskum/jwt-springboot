package com.ggs.service;

import com.ggs.model.User;

import java.util.List;

public interface UserService {

    public User getUserByUsername(String username);
    public User getUserById(String id);
    public List<User> getUsers();

}
