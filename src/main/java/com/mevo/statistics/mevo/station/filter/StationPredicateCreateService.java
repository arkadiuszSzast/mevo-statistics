package com.mevo.statistics.mevo.station.filter;

import com.mevo.statistics.mevo.station.domain.Station;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class StationPredicateCreateService {

    public Predicate<Station> create(StationFilter stationFilter) {
        List<Predicate<Station>> predicates = new ArrayList<>();
        stationFilter.getCity().ifPresent(city -> predicates.add(station -> station.getCity().equalsIgnoreCase(city)));
        stationFilter.getAvailableBikesCountGt().ifPresent(availableBIkes -> predicates.add(station -> station.getAvailableBikesCount() > availableBIkes));

        return predicates
                .stream()
                .reduce(Predicate::and)
                .orElse(t -> true);
    }
}
