package com.mevo.statistics.mevo.station;

import com.mevo.statistics.mevo.data.station.StationsDataGetService;
import com.mevo.statistics.mevo.station.domain.Station;
import com.mevo.statistics.mevo.station.domain.StationRepository;
import com.mevo.statistics.mevo.station.filter.StationFilter;
import com.mevo.statistics.mevo.station.filter.StationPredicateCreateService;
import com.mevo.statistics.mevo.station.filter.StationQueryPredicateCreateService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.io.IOException;

@Service
public class StationGetService {

    private final StationRepository stationRepository;
    private final StationQueryPredicateCreateService stationQueryPredicateCreateService;
    private final StationPredicateCreateService stationPredicateCreateService;
    private final StationsDataGetService stationsDataGetService;

    public StationGetService(StationRepository stationRepository,
                             StationQueryPredicateCreateService stationQueryPredicateCreateService,
                             StationPredicateCreateService stationPredicateCreateService,
                             StationsDataGetService stationsDataGetService) {
        this.stationRepository = stationRepository;
        this.stationQueryPredicateCreateService = stationQueryPredicateCreateService;
        this.stationPredicateCreateService = stationPredicateCreateService;
        this.stationsDataGetService = stationsDataGetService;
    }

    public Flux<Station> getStations(StationFilter stationFilter) {
        var predicate = stationQueryPredicateCreateService.create(stationFilter);
        return stationRepository.findAll(predicate, Sort.by(stationFilter.getSortType(), stationFilter.getSortColumn()));
    }

    protected Flux<Station> getStationsNow(StationFilter bikeFilter) throws IOException {
        var predicate = stationPredicateCreateService.create(bikeFilter);
        return stationsDataGetService.getData()
                .filter(predicate);
    }
}
