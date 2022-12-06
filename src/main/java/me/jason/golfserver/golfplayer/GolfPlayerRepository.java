package me.jason.golfserver.golfplayer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface GolfPlayerRepository extends MongoRepository<GolfPlayer, String> {
    @Query("{phoneNumber:'?0'}")
    GolfPlayer findByPhoneNumber(String phoneNumber);

    public long count();
}
