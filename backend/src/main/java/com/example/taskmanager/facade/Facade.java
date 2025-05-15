package com.example.taskmanager.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taskmanager.exceptions.PasswordInvalidException;
import com.example.taskmanager.exceptions.UserNotFoundException;
import com.example.taskmanager.exceptions.UsernameInvalidException;
import com.example.taskmanager.model.dto.UserDTO;
import com.example.taskmanager.service.TaskService;
import com.example.taskmanager.service.UserService;

import jakarta.servlet.http.HttpSession;

@Service
public class Facade {
    @Autowired
    UserService userService;
    @Autowired
    TaskService taskService;

    public void createTask(String taskName) {

    }

    public void createUser(UserDTO userDTO, HttpSession session)
            throws UsernameInvalidException, PasswordInvalidException {
        userService.createUser(userDTO.getUsername(), userDTO.getPassword(), session);
    }

    public void login(UserDTO userDTO, HttpSession session) throws UserNotFoundException, PasswordInvalidException {
        userService.authenticateUser(userDTO, session);
    }

    public void logout(HttpSession session) {
        session.invalidate();
    }

    public void addTask(String taskName, HttpSession session) {
    }

}
