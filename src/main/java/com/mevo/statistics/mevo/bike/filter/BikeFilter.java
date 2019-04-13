package com.mevo.statistics.mevo.bike.filter;

import java.util.List;
import java.util.Optional;

public class BikeFilter {

    private final Integer batteryGt;
    private final Integer batteryLt;
    private final List<Long> bikeNumbers;

    public BikeFilter(Integer batteryGt, Integer batteryLt, List<Long> bikeNumbers) {
        this.batteryGt = batteryGt;
        this.batteryLt = batteryLt;
        this.bikeNumbers = bikeNumbers;
    }

    protected Optional<Integer> getBatteryGt() {
        return Optional.ofNullable(batteryGt);
    }

    protected Optional<Integer> getBatteryLt() {
        return Optional.ofNullable(batteryLt);
    }

    protected Optional<List<Long>> getBikeNumbers() {
        return Optional.ofNullable(bikeNumbers);
    }
}
