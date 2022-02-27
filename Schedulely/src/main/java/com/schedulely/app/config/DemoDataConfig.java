package com.schedulely.app.config;

import com.schedulely.app.entities.availability.Availability;
import com.schedulely.app.entities.availability.AvailabilityService;
import com.schedulely.app.entities.event.Event;
import com.schedulely.app.entities.event.EventService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

@Configuration
public class DemoDataConfig {

    @Bean
    CommandLineRunner commandLineRunner(EventService eventService, AvailabilityService availabilityService) {
        return args -> {
            Event e1 = new Event("Move night", "Lets set a time to watch the movie tonight! When is everyone available?", "WIlliam", "will@hotmail.com", LocalDate.now(), "discord.com/asdf");
            Event e2 = new Event("Team Meeting", "Hey team, lets set a time to meet tomorrow in preparation for the game this weekend.", "zhang", "zhang@hotmail.com", LocalDate.now(), "zoom.ca/asdf");
            Event e3 = new Event("Fishing", "when can yall get up tmr?", "Jack Ma", "jackma@gmail.com", LocalDate.now(),"discord/123123");
            eventService.addMultipleEvents(Arrays.asList(e1, e2, e3));

            Availability e1a1 = new Availability("Bob", LocalTime.of(20, 30, 0), e1.getId());
            Availability e1a2 = new Availability("Doug", LocalTime.of(21, 0, 0), e1.getId());
            availabilityService.addMultipleAvailabilities(
                    Arrays.asList(e1a1, e1a2)
            );

        };
    }
}
