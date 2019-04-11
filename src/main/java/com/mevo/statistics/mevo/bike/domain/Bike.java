package com.mevo.statistics.mevo.bike.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Bike {

    @JsonProperty("bike")
    private Long bikeNumber;
    private Integer battery;
    private Integer range;
    private boolean active;
    @JsonFormat(pattern = ("yyyy/MM/dd HH:mm:ss"))
    private LocalDateTime date;

    public Bike() {
    }

    public Bike(Long bikeNumber, Integer battery, Integer range, boolean active) {
        this.bikeNumber = bikeNumber;
        this.battery = battery;
        this.range = range;
        this.active = active;
    }

    public Long getBikeNumber() {
        return bikeNumber;
    }

    public void setBikeNumber(Long bikeNumber) {
        this.bikeNumber = bikeNumber;
    }

    public Integer getBattery() {
        return battery;
    }

    public void setBattery(Integer battery) {
        this.battery = battery;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
