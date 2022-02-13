package com.schedulely.app.pages;

import com.schedulely.app.entities.event.Event;
import com.schedulely.app.entities.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class WebpageController {

    @Autowired
    public WebpageController(EventService eventService) {
        this.eventService = eventService;
    }

    private final EventService eventService;

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
        model.addAttribute("event", event);
        return "event";
    }

    @RequestMapping(value = "/joinEvent", method= RequestMethod.GET)
    public String joinEvent(@ModelAttribute Event event) {
        return "redirect:/event/" + event.getId();
    }

    @RequestMapping(value = "/createEvent", method= RequestMethod.POST)
    public String createEvent(@ModelAttribute Event event) {
        this.eventService.addNewEvent(event);
        return "redirect:/event/" + event.getId();
    }

    @RequestMapping(path={"*", "/error"})
    public String notFound(Model model) {
        return "not-found";
    }
}
