package com.gscodelabs.ecom.service;

import com.gscodelabs.ecom.model.entity.User;

import java.util.List;

public interface UserService {

    List<User> fetchAllUsers();

    User addUser(User user);
}
