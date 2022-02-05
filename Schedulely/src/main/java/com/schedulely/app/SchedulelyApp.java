package com.schedulely.app;

import com.schedulely.app.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class SchedulelyApp {

    @Autowired
    public SchedulelyApp(EventService eventService) {
        this.eventService = eventService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SchedulelyApp.class, args);
    }

    private final EventService eventService;


    @RequestMapping(path = "/")
    public String home(Model model) {
        model.addAttribute("message", "Hello World");
        return "index";
    }

    @RequestMapping(path = "/demo")
    public String demo(Model model) {
        return "demo";
    }

    @RequestMapping(path = "/bootstrap")
    public String bootstrap(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "bootstrap";
    }
}
