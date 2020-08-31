package com.example.android101;

public class Task {

    private String titleTask;
    private String descriptionTask;

    public  Task(String title, String desciption){
        titleTask = title;
        descriptionTask = desciption;
    }

    public String getTitleTask() {
        return titleTask;
    }

    public void setTitleTask(String titleTask) {
        this.titleTask = titleTask;
    }

    public String getDescriptionTask() {
        return descriptionTask;
    }

    public void setDescriptionTask(String descriptionTask) {
        this.descriptionTask = descriptionTask;
    }

}
