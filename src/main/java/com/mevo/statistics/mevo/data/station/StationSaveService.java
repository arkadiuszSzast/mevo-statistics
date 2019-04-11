package com.mevo.statistics.mevo.data.station;

import com.mevo.statistics.mevo.station.domain.Station;
import com.mevo.statistics.mevo.station.domain.StationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationSaveService {

    private final StationRepository stationRepository;

    public StationSaveService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public void save(List<Station> stations) {
        stationRepository.saveAll(stations).subscribe();
    }
}
