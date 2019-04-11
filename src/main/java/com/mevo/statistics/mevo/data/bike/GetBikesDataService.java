package com.mevo.statistics.mevo.data.bike;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mevo.statistics.mevo.bike.domain.Bike;
import com.mevo.statistics.mevo.data.locations.ExtractDataFromLocationsService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class GetBikesDataService {

    private static final String GET_BIKES_BATTERIES_PHRASE = "NEXTBIKE_BATTERIES";

    private final ExtractDataFromLocationsService extractDataFromLocationsService;

    public GetBikesDataService(ExtractDataFromLocationsService extractDataFromLocationsService) {
        this.extractDataFromLocationsService = extractDataFromLocationsService;
    }

    public List<Bike> getData() throws IOException {
        var bikes = extractDataFromLocationsService.extractDataFromLocations(GET_BIKES_BATTERIES_PHRASE);
        var stationsAsJsonArray = getJsonWithBikes(bikes);
        return mapToDomain(stationsAsJsonArray);
    }

    private String getJsonWithBikes(String bikes) {
        var startJsonIndex = bikes.indexOf("[");
        var endJsonIndex = bikes.lastIndexOf("]") + 1;
        return bikes.substring(startJsonIndex, endJsonIndex);
    }

    private List<Bike> mapToDomain(String stationsAsJsonArray) {
        var gson = new Gson();
        var typeToMap = new TypeToken<List<Bike>>() {
        }.getType();
        return gson.fromJson(stationsAsJsonArray, typeToMap);
    }

}

