package com.schedulely.app.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/events")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping(path = "{id}")
    public Event getEvent(@PathVariable Long id) {
        return eventService.getEvent(id);
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PostMapping
    public void addNewEvent(@RequestBody Event event) {
        this.eventService.addNewEvent(event);
    }

    @PutMapping(path = "{id}")
    public void updateEventById(@PathVariable Long id, @RequestBody Event event) {
        this.eventService.updateEventById(id, event);
    }

    @DeleteMapping(path = "{id}")
    public void deleteEventById(@PathVariable Long id) {
        this.eventService.deleteEventById(id);
    }

}
