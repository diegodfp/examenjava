package com.examenjava.stack_skill.domain.entity;

public class Stack_Skill {
    private int idskill;
    private int idStack;
    private int idstatus;
    public Stack_Skill() {
    }
    public int getIdskill() {
        return idskill;
    }
    public void setIdskill(int idskill) {
        this.idskill = idskill;
    }
    public int getIdStack() {
        return idStack;
    }
    public void setIdStack(int idStack) {
        this.idStack = idStack;
    }
    public int getIdstatus() {
        return idstatus;
    }
    public void setIdstatus(int idstatus) {
        this.idstatus = idstatus;
    }
    public Stack_Skill(int idskill, int idStack, int idstatus) {
        this.idskill = idskill;
        this.idStack = idStack;
        this.idstatus = idstatus;
    }
    
}
