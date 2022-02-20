package com.schedulely.app.entities.event;

import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
    public Event findByUrlId(String urlId);

}
