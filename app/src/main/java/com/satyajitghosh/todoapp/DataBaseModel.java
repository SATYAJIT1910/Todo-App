package com.satyajitghosh.todoapp;

public class DataBaseModel {
    String title;
    String imp;

    public DataBaseModel(String title,String imp) {
        this.title = title;
        this.imp = imp;
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

}
