package com.example.demo.Model;

import java.util.ArrayList;
import java.util.List;

public class EventModel
{
    private List<BookingModel> bookingModelList;
    private int id;
    private int activityID;
    private ActivityModel activityModel;
    private String time;
    private String date;
    private String activityName;

    public EventModel(int id, String date, String time, int activity_id)
    {
        this.id = id;
        this.date = date;
        this.time = time;
        this.activityID = activity_id;
    }

    public EventModel(int id, String date, String time, ActivityModel activityModel)
    {
        this.id = id;
        this.date = date;
        this.time = time;
        this.activityModel = activityModel;

    }

    //FOR DISPLAYING EVENTS ON /home/events ONLY!!

    public EventModel(int id, String date, String time, String activityName)
    {
        this.id = id;
        this.date = date;
        this.time = time;
        this.activityName = activityName;
    }

    public void setBookingModelList(List<BookingModel> bookingModelList) {
        this.bookingModelList = bookingModelList;
    }

    public void setActivityModel(ActivityModel activityModel) {
        this.activityModel = activityModel;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }
    //Constructor me alle parametre
    // til database
    /**
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getActivityID() {
        return activityID;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public List<BookingModel> getBookingModelList() {
        return bookingModelList;
    }

    public ActivityModel getActivityModel() {
        return activityModel;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public EventModel() {

    }
}
