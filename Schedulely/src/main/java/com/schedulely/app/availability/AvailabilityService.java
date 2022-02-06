package com.schedulely.app.availability;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AvailabilityService {

    private final AvailabilityRepository availabilityRepository;

    @Autowired
    public AvailabilityService(AvailabilityRepository availabilityRepository) {
        this.availabilityRepository =  availabilityRepository;
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

    public void addAvalability(Availability availability) {
        this.availabilityRepository.save(availability);
    }

    public void updateAvailabilityById(Availability availability) {
        this.availabilityRepository.save(availability); //save does both post and update
    }

    public void removeAvailabilityById(Long id) {
        this.availabilityRepository.deleteById(id);
    }
}
