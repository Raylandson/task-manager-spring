package com.example.taskmanager.exceptions;

public class InvalidLoginException extends Exception{
    public InvalidLoginException(String message){
        super(message);
    }

    public InvalidLoginException(){
        super("Invalid username or password");
    }
}
