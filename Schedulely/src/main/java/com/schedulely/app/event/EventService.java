package com.schedulely.app.event;

import com.schedulely.app.availability.Availability;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class EventService {

    HashMap<String, Availability> fakeTable = new HashMap<String, Availability>();
    private List<Event> events = new ArrayList<Event>();

    public EventService( List<Event> events) {
        this.fakeTable.put("beidou zhang", new Availability(3L, "beidou zhang", LocalDate.now()));
        this.fakeTable.put("Justin Bieber", new Availability(2L, "Justin Bieber", LocalDate.now()));

        this.events.add(new Event(1L, " csgo ", " rush b ", fakeTable));
        this.events.add(new Event(2L, " Valorant ", " when u wanna queue?? ", fakeTable));
        this.events.add(new Event(3L, " league ", " queue up  ", fakeTable));

    }

    public Event getEventById(Long id){

        for (int i = 0; i < this.events.size(); ++i) {
            if (this.events.get(i).getId().equals(id)) {
                return this.events.get(i);
            }
        }
        return null;
    }

    public List<Event> getAllEvents(){
        return this.events;
    }

    public void addNewEvent(Event event) {
        this.events.add(event);
    }

    // update
    public void updateEventById(Long id, Event event) {
        for (int i = 0; i < this.events.size(); ++i) {
            if (this.events.get(i).getId().equals(id)) {
                this.events.set(i, event);
            }
        }
    }

    public void deleteEventById(Long id) {
        for (int i = 0; i < this.events.size(); ++i) {
            if (this.events.get(i).getId().equals(id)) {
                this.events.remove(i);
            }
        }
    }

    public void removeAllEvents() {
        this.events.clear();
    }

}
