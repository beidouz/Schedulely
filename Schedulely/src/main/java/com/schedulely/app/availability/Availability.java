package com.schedulely.app.availability;

import java.time.LocalDate;

public class Availability {
    private Long id;
    private String name;
    private LocalDate time;
    //private Long eventId;

    public Availability(){

    }

    public Availability(String name, LocalDate time) {
        this.name = name;
        this.time = time;
    }

    public Availability(Long id, String name, LocalDate time) {
        this.id = id;
        this.name = name;
        this.time = time;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getTime() {
        return this.time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Availability{" +
                "name='" + name + '\'' +
                ", time=" + time +
                '}';
    }
}
