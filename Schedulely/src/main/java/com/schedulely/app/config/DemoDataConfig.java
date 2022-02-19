package com.schedulely.app.config;

import com.schedulely.app.entities.availability.Availability;
import com.schedulely.app.entities.availability.AvailabilityRepository;
import com.schedulely.app.entities.event.Event;
import com.schedulely.app.entities.event.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;
import java.util.Arrays;

@Configuration
public class DemoDataConfig {

    @Bean
    CommandLineRunner commandLineRunner(EventRepository eventRepository, AvailabilityRepository availabilityRepository) {
        return args -> {
            Event e1 = new Event("Demo Event", "This is the event's description!");
            Event e2 = new Event("Team Meeting", "Hey team, lets set a time to meet tomorrow in preparation for the game this weekend.");
            eventRepository.saveAll(
                    Arrays.asList(e1, e2)
            );

            Availability e1a1 = new Availability("User 2", LocalTime.of(9, 30, 0), e1.getId());
            Availability e1a2 = new Availability("User 5", LocalTime.of(10, 30, 0), e1.getId());

            Availability e2a1 = new Availability("Bjergsen", LocalTime.of(20, 30, 0), e2.getId());
            Availability e2a2 = new Availability("Bwipo", LocalTime.of(21, 0, 0), e2.getId());
            Availability e2a3 = new Availability("Steve", LocalTime.of(21, 0, 0), e2.getId());
            availabilityRepository.saveAll(
                    Arrays.asList(e1a1, e1a2, e2a1, e2a2, e2a3)
            );

        };
    }
}
