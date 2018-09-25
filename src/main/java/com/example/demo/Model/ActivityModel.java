package com.example.demo.Model;

public class ActivityModel
{

    //Fields
    private int id;
    private int ageRestriction;
    private String name;
    private String description;

    //Constructor
    public ActivityModel(int id, int ageRestriction, String name, String description)
    {
        this.id = id;
        this.ageRestriction = ageRestriction;
        this.name = name;
        this.description = description;
    }

    //No arg constructor
    public ActivityModel()
    {

    }

    //Getters and Setters
    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "ActivityModel{" +
                ", ageRestriction=" + ageRestriction +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
