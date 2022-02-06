package com.schedulely.app.availability;

import com.schedulely.app.event.Event;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Availability {

    @Id
    private Long id;  // primary key
    private String name;
    private LocalDate time;
    @ManyToOne
    private Event event; // maybe just eventId?

    public Availability(){

    }

    public Availability(Long id, String name, LocalDate time, Long eventId) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.event = new Event(eventId, "", "");
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

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Availability{" +
                "name='" + name + '\'' +
                ", time=" + time +
                '}';
    }
}
