package com.examenjava.gender.domain.entity;

public class Gender {
    private int id;
    private String name;

    
    public Gender() {
    }
    public Gender(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
