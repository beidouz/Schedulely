package com.schedulely.app.event;

import com.schedulely.app.availability.Availability;

import java.util.HashMap;
import java.util.List;

public class Event {
    private Long id; // generated unique ID
    private String title;
    private String description;
    private HashMap<String, Availability> availabilities; // name:time
//    private String eventLink;

    public Event() {

    }

    public Event(String title, String description, HashMap<String, Availability> availabilities) {
        this.title = title;
        this.description = description;
        this.availabilities = availabilities;
    }

    public Event(Long id, String title, String description, HashMap<String, Availability> availabilities) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.availabilities = availabilities;
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

    public HashMap<String, Availability> getAvailabilities() {
        return this.availabilities;
    }

    public void setAvailabilities(HashMap<String, Availability> availabilities) {
        this.availabilities = availabilities;
    }

    public Availability getAvailabilityByName(String name) {
        return this.availabilities.get(name);
    }

    public void setAvailabilityByName(String name, Availability availability) {
        this.availabilities.put(name, availability);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", availabilities=" + availabilities +
                '}';
    }
}
