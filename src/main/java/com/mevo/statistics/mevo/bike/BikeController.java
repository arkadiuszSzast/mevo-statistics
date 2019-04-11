package com.mevo.statistics.mevo.bike;

import com.mevo.statistics.mevo.bike.domain.Bike;
import com.mevo.statistics.mevo.bike.filter.BikeFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class BikeController {

    private final BikeGetService bikeGetService;

    public BikeController(BikeGetService bikeGetService) {
        this.bikeGetService = bikeGetService;
    }

    @GetMapping("/api/bikes")
    public Flux<Bike> getBikes(BikeFilter bikeFilter) {
        return bikeGetService.getBike(bikeFilter);
    }
}
