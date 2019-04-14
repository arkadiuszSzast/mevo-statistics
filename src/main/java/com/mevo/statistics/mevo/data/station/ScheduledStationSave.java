package com.mevo.statistics.mevo.data.station;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ScheduledStationSave {

    private final StationsDataGetService stationsDataGetService;
    private final StationSaveService stationSaveService;

    public ScheduledStationSave(StationsDataGetService stationsDataGetService, StationSaveService stationSaveService) {
        this.stationsDataGetService = stationsDataGetService;
        this.stationSaveService = stationSaveService;
    }

    @Scheduled(cron = "0 0/20 * * * *")
    public void getStationsAndSaveToDb() throws IOException {
        var stations = stationsDataGetService.getData();
        stationSaveService.save(stations);
    }
}
