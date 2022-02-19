package com.schedulely.app.entities.event;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Event {
    @Id
    @SequenceGenerator(
            name = "course_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_seq"
    )
    private Long id; // generated unique ID
    private String title;
    private String description;
    private String ownerName;
    private String ownerEmail;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date; //yyyy-MM-dd

    public Event() {

    }

    public Event(Long id) {
        this.id = id;
        this.title = "";
        this.description = "";
        this.ownerName = "";
        this.ownerEmail = "";
        this.date = null;
    }

    public Event(String title, String description, String ownerName, String ownerEmail, LocalDate date) {
        this.title = title;
        this.description = description;
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
        this.date = date;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
