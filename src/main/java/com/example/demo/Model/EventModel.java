package com.example.demo.Model;

import java.util.ArrayList;
import java.util.List;

public class EventModel
{
    private List<BookingModel> bookingModelList;
    private ActivityModel activityModel;
    private String time;
    private String date;

    //Constructor me alle parametre
    // til database
    /**
     * @param bookingModelList liste over alle bookings til denne event
     * @param activityModel aktivitet denne event er tilknyttet til
     * @param time events tidspunkt
     * @param date
     */
    public EventModel(ActivityModel activityModel, String time, String date)
    {
        this.activityModel = activityModel;
        this.time = time;
        this.date = date;
    }
}
