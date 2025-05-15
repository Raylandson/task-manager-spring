package com.example.taskmanager.service;

import org.springframework.stereotype.Service;

import com.example.taskmanager.model.entity.Task;
import com.example.taskmanager.model.entity.User;

@Service
public class UserService {
    public void addTaskToUser(User user, Task task) {
        user.getTasks().add(task);
    }

    public void removeTaskFromUser(User user, Task task) {
        user.getTasks().remove(task);
    }
}
