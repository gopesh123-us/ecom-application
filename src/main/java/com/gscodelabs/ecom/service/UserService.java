package com.gscodelabs.ecom.service;

import com.gscodelabs.ecom.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> fetchAllUsers();

    User addUser(User user);

    Optional<User> findUser(Long userId);
}
