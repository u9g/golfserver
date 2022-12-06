package me.jason.golfserver.golfplayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/golf_player")
public class GolfPlayerController {
    public GolfPlayerService golfPlayerService;

    @Autowired
    public GolfPlayerController(GolfPlayerService golfPlayerService) {
        this.golfPlayerService = golfPlayerService;
    }

    @PostMapping("/make")
    public String makeGolfPlayer(@RequestBody GolfPlayer golfPlayer) {
        if (golfPlayer.isValid()) {
            golfPlayerService.saveGolfPlayer(golfPlayer);
            return "Ok";
        }
        System.out.println(golfPlayer);
        return "Fail";
    }

    @GetMapping("/by_phone_number")
    public GolfPlayer getGolfPlayerByPhoneNumber(@RequestParam String phoneNumber) {
        // http://localhost:8080/api/v1/golf_player/by_phone_number?phoneNumber=212-111-9012
        // "212-111-9012"
        return golfPlayerService.getGolfPlayerByPhoneNumber(phoneNumber);
    }
}