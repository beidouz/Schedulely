package com.schedulely.app.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event getEventById(Long id){
        return this.eventRepository.findById(id).orElse(null);
    }

    public List<Event> getAllEvents(){
        List<Event> events = new ArrayList<>();
        eventRepository.findAll()
                .forEach(events::add);
        return events;
    }

    public void addNewEvent(Event event) {
        this.eventRepository.save(event);
    }

    public void updateEventById(Event event) {
        this.eventRepository.save(event);
    }

    public void deleteEventById(Long id) {
        this.eventRepository.deleteById(id);
    }
}
