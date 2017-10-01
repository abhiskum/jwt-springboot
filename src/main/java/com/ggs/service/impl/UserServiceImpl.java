package com.ggs.service.impl;

import com.ggs.mapper.UserMapper;
import com.ggs.model.User;
import com.ggs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by abhiskum on 8/29/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUsername(String username) {
        return this.userMapper.findUserByUsername(username);
    }

    @Override
    public User getUserById(String id) {
        return this.userMapper.findUserById(id);
    }

    @Override
    public List<User> getUsers() {
        return this.userMapper.findAll();
    }
}
