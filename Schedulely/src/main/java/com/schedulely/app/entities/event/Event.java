package com.schedulely.app.entities.event;

import javax.persistence.*;

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

    public Event() {

    }

    public Event(Long id) {
        this.id = id;
        this.title = "";
        this.description = "";
        this.ownerName = "";
        this.ownerEmail = "";
    }

    public Event(String title, String description, String ownerName, String ownerEmail) {
        this.title = title;
        this.description = description;
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
    }

    public Event(Long id, String title, String description, String ownerName, String ownerEmail) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
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

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
