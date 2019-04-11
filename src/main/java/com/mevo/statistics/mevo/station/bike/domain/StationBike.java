package com.mevo.statistics.mevo.station.bike.domain;

import com.google.gson.annotations.SerializedName;

public class StationBike {

    private Long number;
    @SerializedName("bike_type")
    private Long bikeType;
    @SerializedName("active")
    private boolean isActive;
    @SerializedName("state")
    private String state;
    @SerializedName("pedelec_battery")
    private Integer battery;

    public StationBike() {
    }

    public StationBike(Long number, Long bikeType, boolean isActive, String state, Integer battery) {
        this.number = number;
        this.bikeType = bikeType;
        this.isActive = isActive;
        this.state = state;
        this.battery = battery;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getBikeType() {
        return bikeType;
    }

    public void setBikeType(Long bikeType) {
        this.bikeType = bikeType;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getBattery() {
        return battery;
    }

    public void setBattery(Integer battery) {
        this.battery = battery;
    }
}
