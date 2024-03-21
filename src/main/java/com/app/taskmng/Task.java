package com.app.taskmng;

public class Task {
    
    private String description;
    private String createdBy;

    public Task(String description, String createdBy) {
        this.description = description;
        this.createdBy = createdBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return createdBy + " : " + description;
    }
}