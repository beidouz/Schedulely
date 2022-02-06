package com.schedulely.app.availability;


import com.schedulely.app.event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/event/{eventId}/availabilities")
public class AvailabilityController {

    private final AvailabilityService availabilityService;

    @Autowired
    public AvailabilityController(AvailabilityService availabilityService) {
        this.availabilityService = availabilityService;
    }

    @GetMapping
    public List<Availability> getAllAvailabilities(@PathVariable Long eventId) {
        return availabilityService.getAllAvailabilities(eventId);
    }

    @GetMapping(path="{availabilityId}")
    public Availability getAvailability(@PathVariable Long availabilityId) {
        return availabilityService.getAvailabilityById(availabilityId);
    }

    @PostMapping
    public void addAvailability(@RequestBody Availability availability, @PathVariable Long eventId) {
        // users are not enforced to pass in the Event Id, service handles it. Initially the ID will be null, then when save is called, replaced with a real id
        availability.setEvent(new Event(eventId, "", ""));
        availabilityService.addAvalability(availability);
    }

    @PutMapping(path="{availabilityId}")
    public void updateAvailabilityById(@RequestBody Availability availability, @PathVariable Long eventId, @PathVariable Long availabilityId) {
        availability.setEvent(new Event(eventId, "", ""));
        // TODO why are we not updating the availabilityID?  maybe remove ID from path?
        availabilityService.updateAvailabilityById(availability);
    }

    @DeleteMapping(path="{id}")
    public void deleteAvailabilityById(@PathVariable Long id) {
        availabilityService.removeAvailabilityById(id);
    }


}
