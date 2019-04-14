package com.mevo.statistics.mevo.station.filter;

import com.mevo.statistics.mevo.station.domain.QStation;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.stereotype.Service;

@Service
public class StationQueryPredicateCreateService {

    public Predicate create(StationFilter stationFilter) {
        var station = QStation.station;
        var predicateBuilder = new BooleanBuilder();
        predicateBuilder.and(station.uid.isNotNull());
        stationFilter.getCity().ifPresent(city -> predicateBuilder.and(station.city.equalsIgnoreCase(city)));
        stationFilter.getAvailableBikesCountGt().ifPresent(availableBikesCount -> predicateBuilder.and(station.availableBikesCount.eq(availableBikesCount)));
        return predicateBuilder.getValue();
    }
}
