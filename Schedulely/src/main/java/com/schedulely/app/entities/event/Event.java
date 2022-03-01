package com.schedulely.app.entities.event;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Event {
    @Id
    @SequenceGenerator(name = "event_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_seq")
    private Long id; // generated unique ID
    @NotNull
    private String title;
    private String description;
    @NotNull
    private String ownerName;
    @NotNull
    private String ownerEmail;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date; //yyyy-MM-dd
    private String location;
    @Column(unique=true)
    @NotNull
    private String urlId;

    public Event() {

    }

    public Event(Long id) {
        this.id = id;
        this.title = "";
        this.description = "";
        this.ownerName = "";
        this.ownerEmail = "";
        this.date = null;
        this.location = "";
        this.urlId = "";
    }

    public Event(String title, String description, String ownerName, String ownerEmail, LocalDate date, String location) {
        this.title = title;
        this.description = description;
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
        this.date = date;
        this.location = location;
        this.urlId = "";
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUrlId() {
        return urlId;
    }

    public void setUrlId(String urlId) {
        this.urlId = urlId;
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
