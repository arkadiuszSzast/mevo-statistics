package com.mevo.statistics.mevo.station.domain;

import com.google.gson.annotations.SerializedName;
import com.mevo.statistics.mevo.station.bike.domain.StationBike;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Document
public class Station {

    private BigInteger uid;
    private Double lat;
    private Double lng;
    private String name;
    private Long number;
    private String city;
    @SerializedName("bikes")
    private Integer availableBikesCount;
    @SerializedName("booked_bikes")
    private Integer bookedBikesCount;
    @SerializedName("bike_racks")
    private Integer bikeRacks;
    @SerializedName("free_racks")
    private Integer availableBikeRacks;
    @SerializedName("bike_list")
    private List<StationBike> stationBikes;
    private LocalDateTime date;


    public Station() {
        this.date = LocalDateTime.now().withSecond(0).withNano(0);
    }

    public Station(BigInteger uid,
                   Double lat,
                   Double lng,
                   String name,
                   Long number,
                   String city,
                   Integer availableBikesCount,
                   Integer bookedBikesCount,
                   Integer bikeRacks,
                   Integer availableBikeRacks,
                   List<StationBike> stationBikes) {
        this.uid = uid;
        this.lat = lat;
        this.lng = lng;
        this.name = name;
        this.number = number;
        this.city = city;
        this.availableBikesCount = availableBikesCount;
        this.bookedBikesCount = bookedBikesCount;
        this.bikeRacks = bikeRacks;
        this.availableBikeRacks = availableBikeRacks;
        this.stationBikes = stationBikes;
        this.date = LocalDateTime.now().withSecond(0).withNano(0);
    }

    public BigInteger getUid() {
        return uid;
    }

    public void setUid(BigInteger uid) {
        this.uid = uid;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Integer getAvailableBikesCount() {
        return availableBikesCount;
    }

    public void setAvailableBikesCount(Integer availableBikesCount) {
        this.availableBikesCount = availableBikesCount;
    }

    public Integer getBookedBikesCount() {
        return bookedBikesCount;
    }

    public void setBookedBikesCount(Integer bookedBikesCount) {
        this.bookedBikesCount = bookedBikesCount;
    }

    public Integer getBikeRacks() {
        return bikeRacks;
    }

    public void setBikeRacks(Integer bikeRacks) {
        this.bikeRacks = bikeRacks;
    }

    public Integer getAvailableBikeRacks() {
        return availableBikeRacks;
    }

    public void setAvailableBikeRacks(Integer availableBikeRacks) {
        this.availableBikeRacks = availableBikeRacks;
    }

    public List<StationBike> getStationBikes() {
        return stationBikes;
    }

    public void setStationBikes(List<StationBike> stationBikes) {
        this.stationBikes = stationBikes;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
