package com.example.authenticationservice.controllers;

import com.example.authenticationservice.models.LoginResponse;
import com.example.authenticationservice.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class AuthenticationController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/auth")
    public ResponseEntity<LoginResponse> login() {
        User user = restTemplate.getForObject("http://user-service/users", User.class);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setStatus("Ok");
        loginResponse.setUser(user);

        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }
}
