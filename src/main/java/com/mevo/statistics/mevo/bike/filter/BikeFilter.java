package com.mevo.statistics.mevo.bike.filter;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class BikeFilter {

    private final Integer batteryGt;
    private final Integer batteryLt;
    private final Integer rangeLt;
    private final Integer rangeGt;
    private final List<Long> bikeNumbers;
    private final LocalDateTime date;
    private final Boolean active;

    public BikeFilter(Integer batteryGt,
                      Integer batteryLt,
                      Integer rangeLt,
                      Integer rangeGt,
                      List<Long> bikeNumbers,
                      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
                      Boolean active) {
        this.batteryGt = batteryGt;
        this.batteryLt = batteryLt;
        this.rangeLt = rangeLt;
        this.rangeGt = rangeGt;
        this.bikeNumbers = bikeNumbers;
        this.date = date;
        this.active = active;
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

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)

    public Optional<LocalDateTime> getDate() {
        return Optional.ofNullable(date);
    }

    public Optional<Boolean> getActive() {
        return Optional.ofNullable(active);
    }

    public Optional<Integer> getRangeLt() {
        return Optional.ofNullable(rangeLt);
    }

    public Optional<Integer> getRangeGt() {
        return Optional.ofNullable(rangeGt);
    }
}
