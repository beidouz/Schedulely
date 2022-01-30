package com.schedulely.app.availability;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/availabilities")
public class AvailabilityController {

    private final AvailabilityService availabilityService;

    @Autowired
    public AvailabilityController(AvailabilityService availabilityService) {
        this.availabilityService = availabilityService;
    }

    @GetMapping(path="{id}")
    public Availability getAvailability(@PathVariable Long id) {
        return availabilityService.getAvailabilityById(id);
    }

    @GetMapping
    public List<Availability> getAllAvailabilities() {
        return availabilityService.getAllAvailabilities();
    }

    @PostMapping
    public void addNewAvailability(@RequestBody Availability availability) {
        availabilityService.addAvalability(availability);
    }

    @PutMapping(path="{id}")
    public void updateAvailabilityById(@PathVariable Long id, @RequestBody Availability availability) {
        availabilityService.updateAvailabilityById(id, availability);
    }

    @DeleteMapping(path="{id}")
    public void deleteAvailabilityById(@PathVariable Long id) {
        availabilityService.removeAvailabilityById(id);
    }


}
