package com.schedulely.app.pages;

import com.schedulely.app.entities.availability.Availability;
import com.schedulely.app.entities.availability.AvailabilityController;
import com.schedulely.app.entities.event.Event;
import com.schedulely.app.entities.event.EventController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalTime;
import java.util.List;

@Controller
public class WebpageController {

    private final EventController eventController;
    private final AvailabilityController availabilityController;

    @Autowired
    public WebpageController(EventController eventController, AvailabilityController availabilityController) {
        this.eventController = eventController;
        this.availabilityController = availabilityController;
    }

    @RequestMapping(path = "/admin")
    public String admin(Model model) {
        List<Event> events = eventController.getAllEvents();
        model.addAttribute("events", events);
        return "admin";
    }

    @RequestMapping(path={"", "/", "home"})
    public String home(Model model) {
        model.addAttribute("event", new Event());
        return "home";
    }

    @RequestMapping(path= "/event/{urlId}")
    public String event(Model model, @PathVariable String urlId) {
        Event event = eventController.getEventByUrlId(urlId);
        List<Availability> availabilities = availabilityController.getAllAvailabilities(event.getId());
        Availability availability = new Availability("", LocalTime.of(0, 0, 0), event.getId());
        model.addAttribute("event", event);
        model.addAttribute("availabilities", availabilities);
        model.addAttribute("availability", availability);
        return "event";
    }

    @RequestMapping(value = "/joinEvent", method= RequestMethod.GET)
    public String joinEvent(@ModelAttribute Event event) {
        if (this.eventController.getEventByUrlId(event.getUrlId()) != null) {
            return "redirect:/event/" + event.getUrlId();
        } else {
            return "redirect:/error";
        }
    }

    @RequestMapping(value = "/createEvent", method= RequestMethod.POST)
    public String createEvent(@ModelAttribute Event event) {
        this.eventController.addNewEvent(event);
        return "redirect:/event/" + event.getUrlId();
    }

    @RequestMapping(value = "/addAvailability/{eventUrlId}", method= RequestMethod.POST)
    public String addAvailability(@ModelAttribute Availability availability, @PathVariable String eventUrlId) {
        Long eventId = this.eventController.getEventByUrlId(eventUrlId).getId();
        this.availabilityController.addAvailability(availability, eventId);
        return "redirect:/event/" + eventUrlId;
    }

}
