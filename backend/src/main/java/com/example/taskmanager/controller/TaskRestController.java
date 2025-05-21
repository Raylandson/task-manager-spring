package com.example.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskmanager.facade.Facade;
import com.example.taskmanager.model.dto.TaskDTO;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@RestController
public class TaskRestController {
    @Autowired
    private Facade facade;

    @PostMapping("/addtask")
    public ResponseEntity<String> addTask(@Valid @RequestBody TaskDTO taskDTO,
            HttpSession session, BindingResult result) {
        try {
            if (result.hasErrors()) {
                return ResponseEntity.badRequest().body("Invalid input");
            }
            facade.createTask(taskDTO.getTitle(), session);
            return ResponseEntity.ok("Task added successfully");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping("/deletetask")
    public ResponseEntity<String> deleteTask(@RequestParam Long taskId,
            HttpSession session) {
        try {
            facade.deleteTask(taskId, session);
            return ResponseEntity.ok("Task deleted successfully");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/updatetask")
    public ResponseEntity<String> updateTask(@Valid @RequestBody TaskDTO taskDTO,
            HttpSession session, BindingResult result){
        try {
            if (result.hasErrors()){
                return ResponseEntity.badRequest().body("Invalid input");
            }
            facade.updateTask(taskDTO, session);
            return ResponseEntity.ok("Task updated successfully");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }
}
