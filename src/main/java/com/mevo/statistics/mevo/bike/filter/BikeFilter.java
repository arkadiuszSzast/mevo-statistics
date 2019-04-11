package com.mevo.statistics.mevo.bike.filter;

import java.util.Optional;

public class BikeFilter {

    private final Integer batteryGt;
    private final Integer batteryLt;

    public BikeFilter(Integer batteryGt, Integer batteryLt) {
        this.batteryGt = batteryGt;
        this.batteryLt = batteryLt;
    }

    protected Optional<Integer> getBatteryGt() {
        return Optional.ofNullable(batteryGt);
    }

    protected Optional<Integer> getBatteryLt() {
        return Optional.ofNullable(batteryLt);
    }
}
