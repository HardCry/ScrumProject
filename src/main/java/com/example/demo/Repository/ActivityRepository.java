package com.example.demo.Repository;

import com.example.demo.Model.ActivityModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ActivityRepository
{
    private JdbcTemplate jdbc;

    //Takes an activity model, caches it's values
    //and inserts a new row with the cached values
    public void createActivity(ActivityModel activity)
    {
        int id = activity.getId();
        String name = activity.getName();
        String description = activity.getDescription();
        int ageRestriction = activity.getAgeRestriction();

        jdbc.update("INSERT INTO Activity (id, name, description, age_restriction)\n" +
                "VALUES (" + id + ", " + name + ", " + description + ", " + ageRestriction + ");");
    }

    //Takes an activity model, caches it's values
    //and updates an activity row with the values
    //based on id
    public void updateActivity(ActivityModel activityModel)
    {
        int ageRestriction = activityModel.getAgeRestriction();
        String description = activityModel.getDescription();
        int id = activityModel.getId();
        String name = activityModel.getName();

        String sql = "UPDATE Activity as a " +
                "SET age_restriction = " + ageRestriction + ", description = " + description + ", name = " + name + " " +
                "WHERE a.id = " + id + ";";

        jdbc.update(sql);
    }

    //Creates an activity model from a SqlRowSet
    //based on id, and return a model based on the values
    //of the SqlRowSet
    public ActivityModel getOnId(int id)
    {
        String sql = "SELECT * FROM Activity as a" +
                "WHERE a.id = " + id + ";";
        SqlRowSet rs = jdbc.queryForRowSet(sql);

        int ageRestriction = rs.getInt("age_restriction");
        String description = rs.getString("description");
        String name = rs.getString("name");

        ActivityModel activityModel = new ActivityModel(id, ageRestriction, name, description);
        return activityModel;
    }
}
