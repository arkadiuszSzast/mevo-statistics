package com.mevo.statistics.mevo.data.station;

import com.mevo.statistics.mevo.data.locations.ExtractDataFromLocationsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.test.StepVerifier;

import java.io.IOException;

import static com.mevo.statistics.mevo.data.support.StringSupport.createString;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class tStationsDataGetServiceTest {

    private static final String TEST_DATA_STATIONS_FROM_LOCATIONS = "/test_data/stations/staions_from_locations.txt";

    @Mock
    private ExtractDataFromLocationsService extractDataFromLocationsService;
    @InjectMocks
    private StationsDataGetService stationsDataGetService;

    @Test
    void shouldReturnListOfStations() throws IOException {
        //arrange
        var stationsFromLocationsAsStream = tStationsDataGetServiceTest.class.getResourceAsStream(TEST_DATA_STATIONS_FROM_LOCATIONS);
        var stationsFromLocations = createString(stationsFromLocationsAsStream);
        when(extractDataFromLocationsService.extractDataFromLocations(any())).thenReturn(stationsFromLocations);

        //act
        var result = stationsDataGetService.getData();

        //assert
        StepVerifier.create(result).expectNextCount(672).expectComplete();
    }

}