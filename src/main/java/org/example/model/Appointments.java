package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.SimpleFormatter;

@Entity
public class Appointments {

    @Id
    private String id;
    private String title;
    private String description;
    @Transient
    private int day;
    @Transient
    private int month;
    @Transient
    private int year;
    @Transient
    private int minute;
    @Transient
    private int hour;
    private Date dateOfAppointment;

    public Appointments(String title, String description, int day, int month, int year, int hour, int minute) {
        this.title = title;
        this.description = description;
        this.day = day;
        this.month = month;
        this.year = year;
        this.minute = minute;
        this.hour = hour;
        this.id = day+"-"+month+"-"+year+"-"+hour+"-"+minute;

        this.dateOfAppointment = Date.valueOf(year+"-"+month+"-"+day);

    }

    protected Appointments(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "Appointments{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", minute=" + minute +
                ", hour=" + hour +
                '}';
    }
}
