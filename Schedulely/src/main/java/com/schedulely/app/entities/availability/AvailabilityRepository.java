package com.schedulely.app.entities.availability;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AvailabilityRepository extends CrudRepository<Availability, Long> {

    public List<Availability> findByEventId(Long eventId); //spring data jpa will implemenet the method based on the method name
}
