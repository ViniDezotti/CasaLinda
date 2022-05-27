package com.visual.casalinda;

public class User {

    private int number;
    private String name;
    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = this.action + "/" + action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public User(int number, String name, String action) {
        this.number = number;
        this.name = name;
        this.action = action;
    }
/*
    @Override
    public String toString(){
    return  "User"
    }

 */
}