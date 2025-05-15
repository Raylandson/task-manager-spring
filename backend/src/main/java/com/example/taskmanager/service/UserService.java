package com.example.taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taskmanager.exceptions.PasswordInvalidException;
import com.example.taskmanager.exceptions.UserNotFoundException;
import com.example.taskmanager.exceptions.UsernameInvalidException;
import com.example.taskmanager.model.dto.UserDTO;
import com.example.taskmanager.model.entity.Task;
import com.example.taskmanager.model.entity.User;
import com.example.taskmanager.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void addTaskToUser(String userName, Task task) {
        User user = userRepository.getUser(userName);
        user.getTasks().add(task);
    }

    public void removeTaskFromUser(String userName, Task task) {
        User user = userRepository.getUser(userName);
        user.getTasks().remove(task);
    }

    public void authenticateUser(UserDTO userDTO, HttpSession session) 
    throws UserNotFoundException, PasswordInvalidException {
        User user = userRepository.getUser(userDTO.getUsername());
        if (user == null) {
            throw new UserNotFoundException();
        }
        if (!user.getPassword().equals(userDTO.getPassword())) {
            throw new PasswordInvalidException();
        }
        session.setAttribute("user", user);

    }

    public void createUser(String userName, String password, HttpSession session)
            throws UsernameInvalidException, PasswordInvalidException {
        // doing some validation here
        if (userName == null || userName.isEmpty() || userName.length() > 25) {
            throw new UsernameInvalidException();
        }
        if (password == null || password.isEmpty()
                || password.length() < 6 || password.length() > 25) {
            throw new PasswordInvalidException();
        }
        User newUser = new User(userName, password);
        userRepository.addUser(newUser);
        session.setAttribute("user", newUser);
        
    }

}
