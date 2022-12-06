package me.jason.golfserver.golftime;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface GolfTimeRepository extends MongoRepository<GolfTime, String> {
    @Query("{startDate:'?0', startHour: ?1}")
    List<GolfTime> findIfBusy(String startDate, int startHour);

    public long count();
}
