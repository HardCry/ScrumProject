package com.example.demo.Repository;

import com.example.demo.Model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ActivityRepository
{
    @Autowired
    private JdbcTemplate jdbc;

    public void createActivity(Activity activity)
    {

        String name = activity.getName();
        String description = activity.getDescription();
        int ageRestriction = activity.getAgeRestriction();

        jdbc.update("INSERT INTO Activity (name, age_restriction, description)" +
                "VALUES ('" + name + "', " + ageRestriction + ", '" + description  + "');");

        


    }
}