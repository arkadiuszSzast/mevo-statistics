package com.mevo.statistics.mevo.bike;

import com.mevo.statistics.mevo.bike.domain.Bike;
import com.mevo.statistics.mevo.bike.domain.BikeRepository;
import com.mevo.statistics.mevo.bike.filter.BikeFilter;
import com.mevo.statistics.mevo.bike.filter.BikePredicateCreateService;
import com.mevo.statistics.mevo.bike.filter.BikeQueryPredicateCreateService;
import com.mevo.statistics.mevo.data.bike.BikesDataGetService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.io.IOException;

@Service
public class BikeGetService {

    private final BikeRepository bikeRepository;
    private final BikeQueryPredicateCreateService bikeQueryPredicateCreateService;
    private final BikesDataGetService bikesDataGetService;
    private final BikePredicateCreateService bikePredicateCreateService;

    public BikeGetService(BikeRepository bikeRepository,
                          BikeQueryPredicateCreateService bikeQueryPredicateCreateService,
                          BikesDataGetService bikesDataGetService,
                          BikePredicateCreateService bikePredicateCreateService) {
        this.bikeRepository = bikeRepository;
        this.bikeQueryPredicateCreateService = bikeQueryPredicateCreateService;
        this.bikesDataGetService = bikesDataGetService;
        this.bikePredicateCreateService = bikePredicateCreateService;
    }

    protected Flux<Bike> getBikes(BikeFilter bikeFilter) {
        var predicate = bikeQueryPredicateCreateService.create(bikeFilter);
        return bikeRepository.findAll(predicate);
    }

    protected Flux<Bike> getBikesNow(BikeFilter bikeFilter) throws IOException {
        var predicate = bikePredicateCreateService.create(bikeFilter);
        var bikes = bikesDataGetService.getData();
        return Flux.fromStream(bikes
                .stream())
                .filter(predicate);
    }
}
