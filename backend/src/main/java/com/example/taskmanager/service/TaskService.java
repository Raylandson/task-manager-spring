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
        taskRepository.save(task);
        return task;
    }

    public void deleteTask(long taskId, long userId) {
        Task task = taskRepository.findById(taskId).orElse(null);
        if (task == null || task.getUserId() != userId) {
            // throw exception here
            return;
        }
        taskRepository.delete(task);
    }

    public ArrayList<Task> getTasksById(long userId) {
        return taskRepository.getAllTasksByUserId(userId);
    }

    public void updateTask(long taskId, String taskTitle, boolean completed) {
        Task task = taskRepository.findById(taskId).orElse(null);
        if (task == null) {
            // throw exception here
            return;
        }
        task.setTitle(taskTitle);
        task.setCompleted(completed);
        taskRepository.save(task);
    }
}
