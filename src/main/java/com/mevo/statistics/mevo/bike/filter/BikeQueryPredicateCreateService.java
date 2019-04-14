package com.mevo.statistics.mevo.bike.filter;

import com.mevo.statistics.mevo.bike.domain.QBike;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.stereotype.Service;

@Service
public class BikeQueryPredicateCreateService {

    public Predicate create(BikeFilter bikeFilter) {
        var bike = QBike.bike;
        var predicateBuilder = new BooleanBuilder();
        predicateBuilder.and(bike.bikeNumber.isNotNull());
        bikeFilter.getBatteryGt().ifPresent(battery -> predicateBuilder.and(bike.battery.gt(battery)));
        bikeFilter.getBatteryLt().ifPresent(battery -> predicateBuilder.and(bike.battery.lt(battery)));
        bikeFilter.getBikeNumbers().ifPresent(bikeNumbers -> predicateBuilder.and(bike.bikeNumber.in(bikeNumbers)));
        bikeFilter.getDate().ifPresent(date -> predicateBuilder.and(bike.date.eq(date)));
        bikeFilter.getActive().ifPresent(isActive -> predicateBuilder.and(bike.active.eq(isActive)));
        bikeFilter.getRangeLt().ifPresent(rangeLt -> predicateBuilder.and(bike.range.lt(rangeLt)));
        bikeFilter.getRangeGt().ifPresent(rangeGt -> predicateBuilder.and(bike.range.gt(rangeGt)));
        return predicateBuilder.getValue();
    }
}
