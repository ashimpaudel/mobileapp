package com.example.ashim.mobileappfinalproject;

/**
 * Created by Ashim on 11/25/2016.
 */

public class Product {
    private  String event, department, date, time;

    public Product(String event, String department, String date, String time)
    {
        this.setEvent(event);
        this.setDepartment(department);
        this.setDate(date);
        this.setTime(time);
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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
}
