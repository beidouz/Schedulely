package com.schedulely.app.config;

import com.schedulely.app.entities.availability.Availability;
import com.schedulely.app.entities.availability.AvailabilityRepository;
import com.schedulely.app.entities.event.Event;
import com.schedulely.app.entities.event.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
public class DemoDataConfig {

    @Bean
    CommandLineRunner commandLineRunner(EventRepository eventRepository, AvailabilityRepository availabilityRepository) {
        return args -> {
            Event e1 = new Event("Move night", "Lets set a time to watch the movie tonight! When is everyone available?");
            Event e2 = new Event("Team Meeting", "Hey team, lets set a time to meet tomorrow in preparation for the game this weekend.");
            Event e3 = new Event("Fishing", "when can yall get up tmr?");
            eventRepository.saveAll(
                    Arrays.asList(e1, e2, e3)
            );

            Availability e1a1 = new Availability("Bob", LocalDateTime.of(2022, 2, 11, 20, 30, 0), 1L);
            Availability e1a2 = new Availability("Doug", LocalDateTime.of(2020, 2, 11, 21, 00, 0), 1L);
            availabilityRepository.saveAll(
                    Arrays.asList(e1a1, e1a2)
            );

        };
    }
}
