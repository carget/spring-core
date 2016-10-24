package com.mishkurov;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Anton_Mishkurov
 */
//@Component
public class Event {
    private int id;
    private String message;
    private LocalDate date;
    private DateTimeFormatter dateFormat;

    public Event(LocalDate date, DateTimeFormatter dateFormat) {
        this.dateFormat = dateFormat;
        this.id = (int) (Math.random() * Integer.MAX_VALUE);
        this.date = date;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", date=" + dateFormat.format(date) +
                '}';
    }
}
