package com.example.userservice.controllers;

import com.example.userservice.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {

    @GetMapping("/users")
    public ResponseEntity<User> getUser() {
        User user = new User();
        user.setName("test");
        user.setAge(10);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
