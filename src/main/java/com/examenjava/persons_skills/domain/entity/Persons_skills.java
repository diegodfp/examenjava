package com.examenjava.persons_skills.domain.entity;

import java.sql.Date;

public class Persons_skills {
    private int id;
    private Date registration_date;
    private int idperson;
    private int idskill;
    public Persons_skills() {
    }
    public Persons_skills(int id, Date registration_date, int idperson, int idskill) {
        this.id = id;
        this.registration_date = registration_date;
        this.idperson = idperson;
        this.idskill = idskill;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getRegistration_date() {
        return registration_date;
    }
    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }
    public int getIdperson() {
        return idperson;
    }
    public void setIdperson(int idperson) {
        this.idperson = idperson;
    }
    public int getIdskill() {
        return idskill;
    }
    public void setIdskill(int idskill) {
        this.idskill = idskill;
    }

    
}
