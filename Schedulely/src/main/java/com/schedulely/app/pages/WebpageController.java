package com.schedulely.app.pages;

import com.schedulely.app.event.Event;
import com.schedulely.app.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
