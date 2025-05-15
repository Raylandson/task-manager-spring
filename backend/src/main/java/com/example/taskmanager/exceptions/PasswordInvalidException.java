package com.example.taskmanager.exceptions;

public class PasswordInvalidException extends Exception {
    public PasswordInvalidException(String message){
        super(message);
    }

    public PasswordInvalidException(){
        super("Password is invalid");
    }

}
