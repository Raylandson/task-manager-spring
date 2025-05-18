package com.example.taskmanager.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taskmanager.exceptions.InvalidLoginException;
import com.example.taskmanager.exceptions.PasswordInvalidException;
import com.example.taskmanager.exceptions.UsernameInvalidException;
import com.example.taskmanager.model.dto.UserDTO;
import com.example.taskmanager.model.entity.Task;
import com.example.taskmanager.model.entity.User;
import com.example.taskmanager.service.TaskService;
import com.example.taskmanager.service.UserService;

import jakarta.servlet.http.HttpSession;

@Service
public class Facade {
    @Autowired
    UserService userService;
    @Autowired
    TaskService taskService;

    public void createTask(String taskName, HttpSession session)
        throws Exception {
        User user = (User) session.getAttribute("user");
        if(user == null) {
            throw new Exception("User not logged in");
        }        //taskService.createTask(taskName, session);
        long userId = user.getId();

        Task newTask = taskService.createTask(userId, taskName);

        user.addTask(newTask);

    }

    public void createUser(UserDTO userDTO, HttpSession session)
            throws UsernameInvalidException, PasswordInvalidException {
        userService.createUser(userDTO.getUsername(), userDTO.getPassword(), session);
    }

    public void login(UserDTO userDTO, HttpSession session)
            throws InvalidLoginException {
        User logged_user = userService.authenticateUser(userDTO, session);
        logged_user.setTasks(taskService.getTasksById(logged_user.getId()));
        System.out.println("Logged in user: " + logged_user.getUsername());
        System.out.println("Logged in user tasks: " + logged_user.getTasks());
    }

    public void logout(HttpSession session) {
        session.invalidate();
    }

    public void addTask(String taskName, HttpSession session) {
    }

}
