package com.example.demo.Model;

public class Activity
{

    //Fields
    private int activityId;
    private int ageRestriction;
    private String name;
    private String description;

    //Constructor
    public Activity(int activityId, int ageRestriction, String name, String description)
    {
        this.activityId = activityId;
        this.ageRestriction = ageRestriction;
        this.name = name;
        this.description = description;
    }

    //No arg constructor
    public Activity()
    {

    }

    //Getters and Setters
    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //ToString
    @Override
    public String toString() {
        return "Activity:" +
                "ageRestriction: " + ageRestriction +
                ", name: '" + name + '\'' +
                ", description: '" + description + '\'';
    }
}
