package com.schedulely.app.availability;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AvailabilityService {

    private List<Availability> availabilities = new ArrayList<>(Arrays.asList(
            new Availability(1L, "BeidouZhang", LocalDate.now()),
            new Availability(2L, "Jay chou", LocalDate.now()),
            new Availability(3L, "Your mother", LocalDate.now())
    ));

    public List<Availability> getAllAvailabilities(){
        return getAllAvailabilities();
    }

    public Availability getAvailabilityById(Long id) {
        return availabilities.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addAvalability(Availability availability) {
        availabilities.add(availability);
    }

    public void updateAvailabilityById(Long id, Availability availability) {
        for (int i = 0; i < availabilities.size(); ++i) {
            Availability a = availabilities.get(i);
            if (a.getId().equals(id)) {
                availabilities.set(i, availability);
                return;
            }
        }
    }

    public void removeAvailability(Long id) {
        availabilities.removeIf(t -> t.getId().equals(id));
    }
}
