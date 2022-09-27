package com.example.testTask.dto;

public class Sort {
    private String direction= "ASC";
    private String property = "id";

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getDirection() {
        return direction;
    }
}
