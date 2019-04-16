package com.mevo.statistics.mevo.station.filter;


import org.springframework.data.domain.Sort;

import java.util.Optional;

public class StationFilter {

    private final String city;
    private final Integer availableBikesCountGt;
    private final String sortColumn;
    private final Sort.Direction sortType;

    public StationFilter(String city,
                         Integer availableBikesCountGt,
                         String sortColumn,
                         Sort.Direction sortType) {
        this.city = city;
        this.availableBikesCountGt = availableBikesCountGt;
        this.sortColumn = sortColumn;
        this.sortType = sortType;
    }

    public Optional<String> getCity() {
        return Optional.ofNullable(city);
    }

    public Optional<Integer> getAvailableBikesCountGt() {
        return Optional.ofNullable(availableBikesCountGt);
    }

    public String getSortColumn() {
        return sortColumn != null ? sortColumn : "uid";
    }

    public Sort.Direction getSortType() {
        return sortType != null ? sortType : Sort.Direction.ASC;
    }
}
