package com.mevo.statistics.mevo.data.bike;

import com.mevo.statistics.mevo.bike.domain.Bike;
import com.mevo.statistics.mevo.data.locations.ExtractDataFromLocationsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static com.mevo.statistics.mevo.data.support.StringSupport.createString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class BikesDataGetServiceTest {

    private static final String TEST_DATA_BIKES_FROM_LOCATIONS = "/test_data/bikes/bikes_from_locations.txt";

    @Mock
    private ExtractDataFromLocationsService extractDataFromLocationsService;
    @InjectMocks
    private BikesDataGetService bikesDataGetService;


    @Test
    void shouldReturnListOfBikes() throws IOException {
        //arrange
        var bikesFromLocationsAsStream = BikesDataGetServiceTest.class.getResourceAsStream(TEST_DATA_BIKES_FROM_LOCATIONS);
        var bikesFromLocations = createString(bikesFromLocationsAsStream);

        when(extractDataFromLocationsService.extractDataFromLocations(any())).thenReturn(bikesFromLocations);
        //act
        var result = bikesDataGetService.getData();

        //assert
        assertThat(result).hasSize(487);
        assertThat(result.get(0)).isInstanceOf(Bike.class);
    }
}