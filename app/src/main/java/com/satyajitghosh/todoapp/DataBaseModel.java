package com.satyajitghosh.todoapp;

public class DataBaseModel {
    String title;
    String imp;
    String done;

    public DataBaseModel(String title, String imp, String done) {
        this.title = title;
        this.imp = imp;
        this.done = done;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImp() {
        return imp;
    }

    public void setImp(String imp) {
        this.imp = imp;
    }

    public String getDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done;
    }
}
