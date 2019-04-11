package com.mevo.statistics.mevo.data.bike;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ScheduledBikeSave {

    private final GetBikesDataService getBikesDataService;
    private final BikeSaveService bikeSaveService;

    public ScheduledBikeSave(GetBikesDataService getBikesDataService, BikeSaveService bikeSaveService) {
        this.getBikesDataService = getBikesDataService;
        this.bikeSaveService = bikeSaveService;
    }

    @Scheduled(cron = "0 0/20 * * * *")
    public void getBikesAndSaveToDb() throws IOException {
        var bikes = getBikesDataService.getData();
        bikeSaveService.save(bikes);
    }
}
