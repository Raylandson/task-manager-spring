package com.example.taskmanager.exceptions;

public class UsernameInvalidException extends Exception {
    public UsernameInvalidException(String message){
        super(message);
    }

    public UsernameInvalidException(){
        super("Username is invalid");
    }
}
