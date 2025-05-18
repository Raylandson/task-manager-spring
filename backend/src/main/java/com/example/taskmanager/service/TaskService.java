package com.example.taskmanager.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taskmanager.model.entity.Task;
import com.example.taskmanager.repository.TaskRepository;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(long userId, String taskName) {
        Task task = new Task(userId, taskName, false);
        taskRepository.addTask(task);
        return task;
    }

    public ArrayList<Task> getTasksById(long userId) {
        return taskRepository.getAllTasksByUserId(userId);
    }
}
