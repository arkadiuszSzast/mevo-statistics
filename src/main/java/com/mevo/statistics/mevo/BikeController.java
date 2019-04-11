package com.mevo.statistics.mevo;

import com.mevo.statistics.mevo.bike.BikeGetService;
import com.mevo.statistics.mevo.bike.domain.Bike;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class BikeController {

    private final BikeGetService bikeGetService;

    public BikeController(BikeGetService bikeGetService) {
        this.bikeGetService = bikeGetService;
    }

    @GetMapping("/test")
    public Flux<Bike> test(){
        return bikeGetService.getBike();
    }
}
