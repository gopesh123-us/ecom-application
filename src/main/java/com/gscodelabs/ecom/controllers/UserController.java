package com.gscodelabs.ecom.controllers;

import com.gscodelabs.ecom.model.entity.User;
import com.gscodelabs.ecom.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.fetchAllUsers());
    }

    @PostMapping("/api/createUser")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.addUser(user));
    }

    @GetMapping("/api/findUser/{id}")
    public ResponseEntity<String> findUser(@PathVariable Long id) {
        Optional<User> opt = userService.findUser(id);
        if (opt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("User Found: " + opt.get().getName());
        }
    }
}
