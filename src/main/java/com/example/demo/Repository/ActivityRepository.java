package com.example.demo.Repository;

import com.example.demo.Model.ActivityModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ActivityRepository
{
    private JdbcTemplate jdbc;

    public void createActivity(ActivityModel activity)
    {
        int id = activity.getId();
        String name = activity.getName();
        String description = activity.getDescription();
        int ageRestriction = activity.getAgeRestriction();

        jdbc.update("INSERT INTO Activity (id, name, description, age_restriction)\n" +
                "VALUES (" + id + ", " + name + ", " + description + ", " + ageRestriction + ");");
    }
}
