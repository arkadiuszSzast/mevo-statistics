package com.mevo.statistics.mevo.data.station;

import com.mevo.statistics.mevo.station.domain.Station;
import com.mevo.statistics.mevo.station.domain.StationRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class StationSaveService {

    private final StationRepository stationRepository;

    public StationSaveService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public void save(Flux<Station> stations) {
        stationRepository.saveAll(stations).subscribe();
    }
}
