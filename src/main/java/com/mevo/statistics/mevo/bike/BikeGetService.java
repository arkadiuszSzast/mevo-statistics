package com.mevo.statistics.mevo.bike;

import com.mevo.statistics.mevo.bike.domain.Bike;
import com.mevo.statistics.mevo.bike.domain.BikeRepository;
import com.mevo.statistics.mevo.bike.filter.BikeFilter;
import com.mevo.statistics.mevo.bike.filter.BikeFilterCreatorService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class BikeGetService {

    private final BikeRepository bikeRepository;
    private final BikeFilterCreatorService bikeFilterCreatorService;

    public BikeGetService(BikeRepository bikeRepository, BikeFilterCreatorService bikeFilterCreatorService) {
        this.bikeRepository = bikeRepository;
        this.bikeFilterCreatorService = bikeFilterCreatorService;
    }

    protected Flux<Bike> getBike(BikeFilter bikeFilter) {
        var predicate = bikeFilterCreatorService.create(bikeFilter);
        return bikeRepository.findAll(predicate);
    }
}
