package me.jason.golfserver.golfplayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GolfPlayerService {
    @Autowired
    GolfPlayerRepository repository;

    void saveGolfPlayer(GolfPlayer player) {
        repository.save(player);
    }

    public GolfPlayer getGolfPlayerByPhoneNumber(String phoneNumber) {
        return repository.findByPhoneNumber(phoneNumber);
    }
}
