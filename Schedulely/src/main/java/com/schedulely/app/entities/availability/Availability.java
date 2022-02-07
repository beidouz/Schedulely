package com.schedulely.app.entities.availability;

import com.schedulely.app.entities.event.Event;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Availability {

    @Id
    @SequenceGenerator(
            name = "availability_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "availability_seq"
    )
    private Long id;  // primary key
    private String name;
    private LocalDate time;

    // Todo: add fk constraint to Event
    @ManyToOne
    private Event event;

    public Availability(){

    }

    public Availability(String name, LocalDate time, Long eventId) {
        this.name = name;
        this.time = time;
        this.event = new Event(eventId, "", "");
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
