package me.jason.golfserver.golftime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GolfTimeService {
    @Autowired
    GolfTimeRepository repository;

    void saveGolfTime(GolfTime time) {
        repository.save(time);
    }

    public boolean isAvailableFor(String endDate, int startHour, int startMinute) {
        // TODO: Handle going over to next day / hour
        return repository
                .findIfBusy(endDate, startHour).stream()
                .noneMatch(c -> c.getStartHour() == startHour && Math.abs(c.getStartMinute() - startMinute) < 5);
    }
}
