package com.example.demo.Model;

public class ActivityModel
{

    //Fields
    private int id;
    private int ageRestriction;
    private String name;
    private String description;

    //Constructor
    public ActivityModel(int id,  int ageRestriction, String name, String description)
    {
        this.id = id;
        this.name = name;
        this.ageRestriction = ageRestriction;
        this.description = description;
    }
    public ActivityModel(String name)
    {
        this.name = name;
    }

    //No arg constructor
    public ActivityModel()
    {

    }
    public ActivityModel(int id)
    {
        this.id = id;
    }

    public ActivityModel(String name, int id)
    {
        this.name = name;
        this.id = id;
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
