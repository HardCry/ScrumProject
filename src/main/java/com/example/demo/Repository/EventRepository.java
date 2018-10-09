package com.example.demo.Repository;

import com.example.demo.Model.ActivityModel;
import com.example.demo.Model.EventModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EventRepository {

    @Autowired
    JdbcTemplate jdbc;
    private List<EventModel> list;

    @Autowired
    ActivityRepository activityRepository = new ActivityRepository();

    public void createEvent(EventModel eventModel)
    {
        System.out.println(Integer.parseInt(eventModel.getActivityModel().getName()));
        int activityID = Integer.parseInt(eventModel.getActivityModel().getName());
        String date = eventModel.getDate();
        String time = eventModel.getTime();

        System.out.println(activityID + date + time);

        String sql = "INSERT INTO Event(activity_id, date, time)" +
                "VALUES(" + activityID + ", '" + date + "', '" + time + "');";

                /*"INSERT INTO Event (activity_id, date, time)" +
                "VALUES(" + activityID + ", '" + date + "', '" + time + "');";*/

        jdbc.update(sql);

    }

    public List<EventModel> getList() {
        List<EventModel> eventList = new ArrayList<>();

        String sql = "SELECT * From Event;";
        SqlRowSet rs = jdbc.queryForRowSet(sql);

        while (rs.next())
        {
            eventList.add(new EventModel(rs.getInt("id"),
                    rs.getString("date"),
                    rs.getString("time"),
                    activityRepository.getOnId(rs.getInt("activity_id")).getName()));
        }

        return eventList;

    }
}
