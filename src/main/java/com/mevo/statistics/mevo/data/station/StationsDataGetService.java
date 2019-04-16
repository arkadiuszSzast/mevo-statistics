package com.mevo.statistics.mevo.data.station;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mevo.statistics.mevo.data.locations.ExtractDataFromLocationsService;
import com.mevo.statistics.mevo.station.domain.Station;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.util.List;

@Service
public class StationsDataGetService {

    private static final String GET_STATIONS_PHRASE = "NEXTBIKE_PLACES_DB";

    private final ExtractDataFromLocationsService extractDataFromLocationsService;

    public StationsDataGetService(ExtractDataFromLocationsService extractDataFromLocationsService) {
        this.extractDataFromLocationsService = extractDataFromLocationsService;
    }

    public Flux<Station> getData() throws IOException {
        var stations = extractDataFromLocationsService.extractDataFromLocations(GET_STATIONS_PHRASE);
        var stationsAsJsonArray = getJsonWithStations(stations);
        return Flux.fromStream(mapToDomain(stationsAsJsonArray).stream());
    }

    private String getJsonWithStations(String stations) {
        var startJsonIndex = stations.indexOf(":") + 1;
        var endJsonIndex = stations.lastIndexOf("}");
        return stations.substring(startJsonIndex, endJsonIndex);
    }

    private List<Station> mapToDomain(String stationsAsJsonArray) {
        var gson = new Gson();
        var typeToMap = new TypeToken<List<Station>>() {
        }.getType();
        return gson.fromJson(stationsAsJsonArray, typeToMap);
    }
}
