package com.schedulely.app.event;

import com.schedulely.app.availability.Availability;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashMap;
import java.util.List;

@Entity
public class Event {
    @Id
    private Long id; // generated unique ID
    private String title;
    private String description;

    public Event() {

    }

    public Event(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
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


//    public void setAvailabilities(HashMap<String, Availability> availabilities) {
//        this.availabilities = availabilities;
//    }

//    public Availability getAvailabilityByName(String name) {
//        return this.availabilities.get(name);
//    }

//    public void setAvailabilityByName(String name, Availability availability) {
//        this.availabilities.put(name, availability);
//    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
