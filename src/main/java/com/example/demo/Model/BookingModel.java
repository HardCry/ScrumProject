package com.example.demo.Model;

public class BookingModel {
    private int id;
    private String date;
    private String time;

    //private int activity_id //skal det med?? fra sql

    public BookingModel(){}

    public BookingModel(int id, String date, String time) {
        this.id = id;
        this.date = date;
        this.time = time;
    }
    //denne id referer til aktivitets id så man kan matche agtigt

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return id + getTime() + getDate();
    }
}
