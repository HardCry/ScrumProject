package com.example.demo.Repository;

import com.example.demo.Model.EventModel;

public class EventRepository {
    public void createEvent(EventModel eventModel)
    {
        int activityID = eventModel.getActivityModel().getid();
        String date = eventModel.getDate();
        String time = eventModel.getTime();

        String sql = "INSERT INTO Event (activityid, date, time)" +
                "VALUES(" + activityID + ", '" + date + "', '" + time + "');";
    }
}
