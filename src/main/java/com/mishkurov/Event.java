package com.mishkurov;

import java.time.LocalDate;

/**
 * @author Anton_Mishkurov
 */
public class Event {
    private int id;
    private String message;
    private LocalDate date;

    public Event(LocalDate date) {
        this.id = (int) (Math.random() * Integer.MAX_VALUE);
//        this.message = message;
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
                ", date=" + date +
                '}';
    }
}
