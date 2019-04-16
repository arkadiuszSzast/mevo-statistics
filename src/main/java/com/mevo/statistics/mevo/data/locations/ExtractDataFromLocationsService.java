package com.mevo.statistics.mevo.data.locations;

import com.mevo.statistics.mevo.data.token.TokenGetService;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class ExtractDataFromLocationsService {

    private final TokenGetService tokenGetService;

    public ExtractDataFromLocationsService(TokenGetService tokenGetService) {
        this.tokenGetService = tokenGetService;
    }

    public String extractDataFromLocations(String searchingText) throws IOException {
        var httpURLConnection = sendRequest();
        return extractData(httpURLConnection, searchingText);
    }

    private HttpURLConnection sendRequest() throws IOException {
        var token = tokenGetService.getToken();
        var url = new URL("https://rowermevo.pl/locations.js?key=" + token);
        return (HttpURLConnection) url.openConnection();
    }

    private String extractData(HttpURLConnection con, String searchingText) throws IOException {
        var bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        return bufferedReader
                .lines()
                .filter(line -> line.contains(searchingText))
                .findFirst()
                .orElseThrow();
    }
}
