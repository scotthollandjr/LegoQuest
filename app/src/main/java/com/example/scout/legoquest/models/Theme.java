package com.example.scout.legoquest.models;

public class Theme {
    private String id;
    private String description;

    public Theme(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
