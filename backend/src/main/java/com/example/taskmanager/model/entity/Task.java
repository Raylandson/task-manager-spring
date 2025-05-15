package com.example.taskmanager.model.entity;

import org.springframework.stereotype.Component;

@Component
public class Task {
    private long id;
    private String title;
    private Boolean completed;

    public Task() {
    }

    public Task(long id, String title, Boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
