package me.jason.golfserver.golftime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/golf_time")
public class GolfTimeController {
    public GolfTimeService golfTimeService;

    @Autowired
    public GolfTimeController(GolfTimeService golfTimeService) {
        this.golfTimeService = golfTimeService;
    }

    @PostMapping("/make")
    public String makeGolfTime(@RequestBody GolfTime golfTime) {
        if (golfTime.isValid()) {
            golfTimeService.saveGolfTime(golfTime);
            return "Ok";
        }
        System.out.println(golfTime);
        return "Fail";
    }

    @GetMapping("/is_available_for")
    public boolean isGolfTimeAvailable(@RequestParam String date, @RequestParam int startHour, @RequestParam int startMinute) { // only for 5 minutes
        // http://localhost:8080/api/v1/golf_time/is_available_for?date=01-01-10&
        // TODO: Handle leaking into next day through midnight
        return golfTimeService.isAvailableFor(date, startHour, startMinute);
    }
}