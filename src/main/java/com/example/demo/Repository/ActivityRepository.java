package com.example.demo.Repository;

import com.example.demo.Model.ActivityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class ActivityRepository
{
    @Autowired
    private JdbcTemplate jdbc;

    public void createActivity(ActivityModel activityModel)
    {

        String name = activityModel.getName();
        String description = activityModel.getDescription();
        int ageRestriction = activityModel.getAgeRestriction();

        jdbc.update("INSERT INTO Activity (name, age_restriction, description)" +
                "VALUES ('" + name + "', " + ageRestriction + ", '" + description  + "');");
    }

    //Takes an activity model, caches it's values
    //and updates an activity row with the values
    //based on id
    public void updateActivity(ActivityModel activityModel)
    {
        int ageRestriction = activityModel.getAgeRestriction();
        String description = activityModel.getDescription();
        int id = activityModel.getid();
        String name = activityModel.getName();

        String sql = "UPDATE Activity as a " +
                "SET age_restriction = '" + ageRestriction + "', description = '" + description +
                "', name = '" + name + "' " +
                "WHERE a.id = " + id + ";";

        jdbc.update(sql);
    }

    //Creates an activity model from a SqlRowSet
    //based on id, and return a model based on the values
    //of the SqlRowSet
    public ActivityModel getOnId(int id)
    {
        String sql = "SELECT * FROM Activity as a " + "WHERE a.id = " + id + ";";

        SqlRowSet rs = jdbc.queryForRowSet(sql);

        rs.next();

        ActivityModel activityModel = new ActivityModel(rs.getInt(1), rs.getInt(3), rs.getString(2), rs.getString(4));
        return activityModel;
    }
}