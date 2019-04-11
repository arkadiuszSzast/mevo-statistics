package com.mevo.statistics.mevo.data.station;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ScheduledStationSave {

    private final GetStationsDataService getStationsDataService;
    private final StationSaveService stationSaveService;

    public ScheduledStationSave(GetStationsDataService getStationsDataService, StationSaveService stationSaveService) {
        this.getStationsDataService = getStationsDataService;
        this.stationSaveService = stationSaveService;
    }

    @Scheduled(cron = "0 0/20 * * * *")
    public void getStationsAndSaveToDb() throws IOException {
        var stations = getStationsDataService.getData();
        stationSaveService.save(stations);
    }
}
