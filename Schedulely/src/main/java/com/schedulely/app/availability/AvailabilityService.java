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

    public List<Availability> getAllAvailabilities(){
        List<Availability> availabilities = new ArrayList<>();
        availabilityRepository.findAll()
                .forEach(availabilities::add);
        return availabilities;
    }

    public Availability getAvailabilityById(Long id) {
        return availabilityRepository.findById(id).orElse(null); //can also do .orElseThrow(() -> new EntityNotFoundException(id));
    }

    public void addAvalability(Availability availability) {
        availabilityRepository.save(availability);
    }

    public void updateAvailabilityById(Long id, Availability availability) {
        availabilityRepository.save(availability); //save does both post and update
    }

    public void removeAvailabilityById(Long id) {
        availabilityRepository.deleteById(id);
    }
}
