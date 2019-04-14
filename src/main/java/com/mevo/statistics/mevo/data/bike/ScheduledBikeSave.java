package com.mevo.statistics.mevo.data.bike;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ScheduledBikeSave {

    private final BikesDataGetService bikesDataGetService;
    private final BikeSaveService bikeSaveService;

    public ScheduledBikeSave(BikesDataGetService bikesDataGetService, BikeSaveService bikeSaveService) {
        this.bikesDataGetService = bikesDataGetService;
        this.bikeSaveService = bikeSaveService;
    }

    @Scheduled(cron = "0 0/20 * * * *")
    public void getBikesAndSaveToDb() throws IOException {
        var bikes = bikesDataGetService.getData();
        bikeSaveService.save(bikes);
    }
}
