package com.examenjava.region.domain.entity;

public class Region {
    private int id;
    private String name;
    private int idcountry;
    public Region() {
    }
    public Region(int id, String name, int idcountry) {
        this.id = id;
        this.name = name;
        this.idcountry = idcountry;
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
    public int getIdcountry() {
        return idcountry;
    }
    public void setIdcountry(int idcountry) {
        this.idcountry = idcountry;
    }
    
}
