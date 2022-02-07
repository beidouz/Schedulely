package com.schedulely.app.entities.availability;

import com.schedulely.app.entities.event.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AvailabilityService {

    private final AvailabilityRepository availabilityRepository;
    private final EventRepository eventRepository;


    @Autowired
    public AvailabilityService(AvailabilityRepository availabilityRepository, EventRepository eventRepository) {
        this.availabilityRepository =  availabilityRepository;
        this.eventRepository = eventRepository;
    }

    public List<Availability> getAllAvailabilities(Long eventId){
        List<Availability> availabilities = new ArrayList<>();
        this.availabilityRepository.findByEventId(eventId)
                .forEach(availabilities::add);
        return availabilities;
    }

    public Availability getAvailabilityById(Long id) {
        return this.availabilityRepository.findById(id).orElse(null); //can also do .orElseThrow(() -> new EntityNotFoundException(id));
    }

    public void addAvailability(Availability availability) {
        //  check we are not trying to overwrite existing data
        if (!eventRepository.existsById(availability.getEvent().getId())){
            // Todo: log and throw error: event should exist
            System.out.printf("Error: event with id %d does not exist", availability.getEvent().getId());
        } else if (availabilityRepository.existsById(availability.getId())){
            // Todo: log and throw error: availability with given id should not exist
            System.out.printf("Error: availability with id %d does not exist", availability.getEvent().getId());
        } else {
            this.availabilityRepository.save(availability);
        }
    }

    public void updateAvailabilityById(Availability availability) {
        this.availabilityRepository.save(availability); //save does both post and update
    }

    public void removeAvailabilityById(Long id) {
        this.availabilityRepository.deleteById(id);
    }
}
