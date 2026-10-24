package com.gscodelabs.ecom.service.impl;

import com.gscodelabs.ecom.model.entity.User;
import com.gscodelabs.ecom.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final List<User> userList = new ArrayList<>();
    private Long id = 1L;

    @Override
    public List<User> fetchAllUsers() {
        return userList;
    }

    @Override
    public User addUser(User user) {
        user.setId(id++);
        userList.add(user);
        return user;
    }

    @Override
    public Optional<User> findUser(Long userId) {

        for (User user : userList) {
            if (user.getId().equals(userId)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}
