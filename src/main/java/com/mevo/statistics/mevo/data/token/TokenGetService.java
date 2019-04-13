package com.mevo.statistics.mevo.data.token;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TokenGetService {

    private static final String SEARCH_PHRASE = "script type=\"text/javascript\" src=\"/locations.js?key=";
    private static final Integer TOKEN_LENGTH = 40;

    public String getToken() throws IOException {
        var url = new URL("https://rowermevo.pl/");
        var con = url.openConnection();
        var bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        var response = bufferedReader
                .lines()
                .collect(Collectors.toList());

        return filterForToken(response);
    }

    private String filterForToken(List<String> response) {
        var lineWithToken = response
                .stream()
                .filter(line -> line.contains(SEARCH_PHRASE))
                .findFirst()
                .orElseThrow();

        var startTokenIndex = lineWithToken.lastIndexOf(SEARCH_PHRASE) + SEARCH_PHRASE.length();
        var endTokenIndex = startTokenIndex + TOKEN_LENGTH;

        return lineWithToken.substring(startTokenIndex, endTokenIndex);
    }
}
