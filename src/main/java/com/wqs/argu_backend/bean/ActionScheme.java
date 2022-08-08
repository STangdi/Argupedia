package com.wqs.argu_backend.bean;

public class ActionScheme {
    private String type;
    private String title;
    private String currentR;
    private String action;
    private String new_s; //new circumstance
    private String goal;
    private String value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurrentR() {
        return currentR;
    }

    public void setCurrentR(String currentR) {
        this.currentR = currentR;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getNew_s() {
        return new_s;
    }

    public void setNew_s(String new_s) {
        this.new_s = new_s;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
