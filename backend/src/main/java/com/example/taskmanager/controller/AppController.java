package com.example.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskmanager.exceptions.PasswordInvalidException;
import com.example.taskmanager.exceptions.UsernameInvalidException;
import com.example.taskmanager.facade.Facade;
import com.example.taskmanager.model.dto.UserDTO;
//import com.example.taskmanager.model.entity.User;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/")
public class AppController {
    @Autowired
    private Facade facade;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserDTO userDTO, HttpSession session) {
        try {
            facade.createUser(userDTO, session);
            return ResponseEntity.ok("User created successfully");
        } catch (UsernameInvalidException e) {
            return ResponseEntity.badRequest().body("Invalid username");
        } catch (PasswordInvalidException e) {
            return ResponseEntity.internalServerError().body("Invalid password");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO userDTO, HttpSession session) {
        try {
            facade.login(userDTO, session);
            return ResponseEntity.ok("User logged in successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Login failed");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> lougout(HttpSession session) {
        try {
            facade.logout(session);
            return ResponseEntity.ok("User logged out successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Logout failed");
        }
    }
}
