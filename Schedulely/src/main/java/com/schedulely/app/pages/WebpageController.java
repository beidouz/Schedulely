package com.schedulely.app.pages;

import com.schedulely.app.entities.availability.Availability;
import com.schedulely.app.entities.availability.AvailabilityService;
import com.schedulely.app.entities.event.Event;
import com.schedulely.app.entities.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class WebpageController {

    @Autowired
    public WebpageController(EventService eventService, AvailabilityService availabilityService) {
        this.eventService = eventService;
        this.availabilityService = availabilityService;
    }

    private final EventService eventService;
    private final AvailabilityService availabilityService;

    @RequestMapping(path = "/admin")
    public String admin(Model model) {
        List<Event> events = eventService.getAllEvents();
        model.addAttribute("events", events);
        return "admin";
    }

    @RequestMapping(path={"", "/", "home"})
    public String home(Model model) {
        model.addAttribute("event", new Event());
        return "home";
    }

    @RequestMapping(path= "/event/{id}")
    public String event(Model model, @PathVariable Long id) {
        Event event = eventService.getEventById(id);
        List<Availability> availabilities = availabilityService.getAllAvailabilities(id);
        Availability availability = new Availability("", LocalDateTime.of(2022, 1, 1, 0, 0, 0), id);
        model.addAttribute("event", event);
        model.addAttribute("availabilities", availabilities);
        model.addAttribute("availability", availability);
        return "event";
    }

    @RequestMapping(value = "/joinEvent", method= RequestMethod.GET)
    public String joinEvent(@ModelAttribute Event event) {
        if (this.eventService.getEventById(event.getId()) != null) {
            return "redirect:/event/" + event.getId();
        } else {
            return "redirect:/error";
        }
    }

    @RequestMapping(value = "/createEvent", method= RequestMethod.POST)
    public String createEvent(@ModelAttribute Event event) {
        this.eventService.addNewEvent(event);
        return "redirect:/event/" + event.getId();
    }

    @RequestMapping(value = "/addAvailability/{eventId}", method= RequestMethod.POST)
    public String addAvailability(@ModelAttribute Availability availability, @PathVariable Long eventId) {
        availability.setEvent(new Event(eventId, "", ""));
        this.availabilityService.addAvailability(availability);
        return "redirect:/event/" + eventId;
    }

    @RequestMapping(path={"*", "/error"})
    public String notFound(Model model) {
        return "not-found";
    }
}
