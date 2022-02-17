package com.schedulely.app.entities.availability;

import com.schedulely.app.entities.event.Event;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime time;

    @ManyToOne
    private Event event;

    public Availability(){

    }

    public Availability(String name, LocalDateTime time, Long eventId) {
        this.name = name;
        this.time = time;
        this.event = new Event(eventId, "", "");
    }

    public Availability(Long id, String name, LocalDateTime time, Long eventId) {
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

    public LocalDateTime getTime() {
        return this.time;
    }

    public void setTime(LocalDateTime time) {
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
