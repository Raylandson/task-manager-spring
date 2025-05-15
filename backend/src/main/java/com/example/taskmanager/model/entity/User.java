package com.example.taskmanager.model.entity;

//import com.example.taskmanager.model.entity.Task;
//import java.util.List;
//import java.util.Objects;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public class User {
    private Long id;
    private String username;
    private String password;
    private ArrayList<Task> tasks;

    public User() {
        System.out.println("User created: " + this.toString());
    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.tasks = new ArrayList<Task>();
        System.out.println("User created: " + this.toString());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

}
