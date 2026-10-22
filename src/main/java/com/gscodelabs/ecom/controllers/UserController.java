package com.gscodelabs.ecom.controllers;

import com.gscodelabs.ecom.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private final List<User> userList = new ArrayList<>();

    @GetMapping("/api/users")
    public List<User> getAllUsers() {
        return userList;
    }

    @PostMapping("/api/createUser")
    public ResponseEntity<List<User>> createUser(@RequestBody User user) {
        userList.add(user);

        String name = user.getName();
        System.out.println("Name: " + name);
        return ResponseEntity.ok(userList);
    }

}
