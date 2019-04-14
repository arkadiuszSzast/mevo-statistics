package com.mevo.statistics.mevo.bike.filter;

import com.mevo.statistics.mevo.bike.domain.Bike;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class BikePredicateCreateService {

    public Predicate<Bike> create(BikeFilter bikeFilter) {
        List<Predicate<Bike>> predicates = new ArrayList<>();
        bikeFilter.getBikeNumbers().ifPresent(bikeNumbers -> predicates.add(bike -> bikeNumbers.contains(bike.getBikeNumber())));
        bikeFilter.getBatteryLt().ifPresent(batteryLt -> predicates.add(bike -> bike.getBattery() < batteryLt));
        bikeFilter.getBatteryGt().ifPresent(batteryGt -> predicates.add(bike -> bike.getBattery() > batteryGt));
        bikeFilter.getDate().ifPresent(date -> predicates.add(bike -> bike.getDate().isEqual(date)));
        bikeFilter.getActive().ifPresent(isActive -> predicates.add(bike -> bike.isActive() == isActive));
        bikeFilter.getRangeLt().ifPresent(rangeLt -> predicates.add(bike -> bike.getRange() < rangeLt));
        bikeFilter.getRangeGt().ifPresent(rangeGt -> predicates.add(bike -> bike.getRange() > rangeGt));
        return predicates
                .stream()
                .reduce(Predicate::and)
                .orElse(t -> true);
    }
}
