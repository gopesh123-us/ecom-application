package com.gscodelabs.ecom.controllers;

import com.gscodelabs.ecom.model.entity.User;
import com.gscodelabs.ecom.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.fetchAllUsers());
    }

    @PostMapping("/createUser")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.addUser(user));
    }

    @GetMapping("/findUser/{id}")
    public ResponseEntity<String> findUser(@PathVariable Long id) {
        return userService.findUser(id)
                .map(user -> ResponseEntity.ok().body("User found: " + user.getName() + ". "))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id: " + id.toString()));
    }

    @RequestMapping(value = "/updateUser/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user).map(updatedUser -> ResponseEntity.ok().body("User " + updatedUser.getName() + " updated")).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id: " + id.toString()));
    }
}
