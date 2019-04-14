package com.mevo.statistics.mevo.station;

import com.mevo.statistics.mevo.station.domain.Station;
import com.mevo.statistics.mevo.station.filter.StationFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.io.IOException;

@RestController
public class StationController {

    private final StationGetService stationGetService;

    public StationController(StationGetService stationGetService) {
        this.stationGetService = stationGetService;
    }

    @GetMapping("/api/stations")
    public Flux<Station> getStations(StationFilter stationFilter) {
        return stationGetService.getStations(stationFilter);
    }

    @GetMapping("/api/stations/now")
    public Flux<Station> getStationsNow(StationFilter stationFilter) throws IOException {
        return stationGetService.getStationsNow(stationFilter);
    }
}
