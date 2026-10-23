package com.gscodelabs.ecom.service.impl;

import com.gscodelabs.ecom.model.entity.User;
import com.gscodelabs.ecom.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final List<User> userList = new ArrayList<>();

    @Override
    public List<User> fetchAllUsers() {
        return userList;
    }

    @Override
    public User addUser(User user) {
        userList.add(user);
        return user;
    }
}
