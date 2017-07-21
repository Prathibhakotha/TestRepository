package com.example.prathibha.testproject.model;

public class Actor {
    public String title;
    public String duration;
    public String description;
    public int imageId;

    @Override
    public String toString() {
        return "Actor{" +
                "title='" + title + '\'' +
                ", duration='" + duration + '\'' +
                ", description='" + description + '\'' +
                ", imageId=" + imageId +
                '}';
    }
}
