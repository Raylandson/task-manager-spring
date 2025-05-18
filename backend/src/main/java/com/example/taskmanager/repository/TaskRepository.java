package com.example.taskmanager.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taskmanager.model.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>  {
    ArrayList<Task> getAllTasksByUserId(long userId);
}
