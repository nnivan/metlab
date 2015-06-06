package com.example.iliq.metlab;

/**
 * Created by iliq on 6/6/15.
 */
public class person {
    String name, description;
    int image;
    public person(String name, String description, int imageUrl) {
        this.name = name;
        this.description = description;
        this.image = imageUrl;
    }
    public person(){super();}
}
