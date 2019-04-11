package com.mevo.statistics.mevo.bike.domain;

import com.google.gson.annotations.SerializedName;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Bike {

    @SerializedName("bike")
    private Long bikeNumber;
    private Integer battery;
    private Integer range;
    private boolean active;
    private LocalDateTime date;

    public Bike() {
        this.date = LocalDateTime.now().withSecond(0).withNano(0);
    }

    public Bike(Long bikeNumber, Integer battery, Integer range, boolean active) {
        this.bikeNumber = bikeNumber;
        this.battery = battery;
        this.range = range;
        this.active = active;
        this.date = LocalDateTime.now().withSecond(0).withNano(0);
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
