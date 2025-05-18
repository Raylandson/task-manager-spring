package com.example.taskmanager.repository;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Repository;

import com.example.taskmanager.model.entity.Task;

@Repository
public class TaskRepository {
    private Queue<Task> tasks = new ConcurrentLinkedQueue<>();

    public ArrayList<Task> getAllTasksByUserId(Long userId) {
        ArrayList<Task> userTasks = new ArrayList<Task>();
        for (Task task : tasks) {
            if (task.getUserId() == userId) {
                userTasks.add(task);
            }
        }
        return userTasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }
}
