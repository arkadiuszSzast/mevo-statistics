package com.mevo.statistics.mevo.bike.filter;

import com.mevo.statistics.mevo.bike.domain.QBike;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.stereotype.Service;

@Service
public class BikeFilterCreatorService {

    public Predicate create(BikeFilter bikeFilter) {
        var bike = QBike.bike;
        var predicateBuilder = new BooleanBuilder();
        bikeFilter.getBatteryGt().ifPresent(battery -> predicateBuilder.and(bike.battery.gt(battery)));
        bikeFilter.getBatteryLt().ifPresent(battery -> predicateBuilder.and(bike.battery.lt(battery)));
        return predicateBuilder.getValue();
    }
}
