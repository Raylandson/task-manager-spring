package com.example.taskmanager.exceptions;

public class TaskInvalidNameException extends Exception {
    public TaskInvalidNameException(String message){
        super(message);
    }

    public TaskInvalidNameException(){
        super("Task name is invalid");
    }
}
