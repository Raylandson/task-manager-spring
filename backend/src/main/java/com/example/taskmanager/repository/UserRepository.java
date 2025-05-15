package com.example.taskmanager.repository;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Repository;

import com.example.taskmanager.exceptions.UsernameInvalidException;
import com.example.taskmanager.model.entity.User;

@Repository
public class UserRepository {

    private Queue<User> users;

    public UserRepository() {
        this.users = new ConcurrentLinkedQueue<>();
    }

    public void addUser(User user) throws UsernameInvalidException {
        for (User existingUser : users) {
            if (existingUser.getUsername().equals(user.getUsername())) {
                throw new UsernameInvalidException();
            }
        }
        users.add(user);
    }

    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public void removeUser(String username) {
        users.removeIf(user -> user.getUsername().equals(username));
    }

    public Queue<User> getUsers() {
        return users;
    }
}
