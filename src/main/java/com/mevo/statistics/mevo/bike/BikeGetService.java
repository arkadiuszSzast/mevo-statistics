package com.mevo.statistics.mevo.bike;

import com.mevo.statistics.mevo.bike.domain.Bike;
import com.mevo.statistics.mevo.bike.domain.BikeRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class BikeGetService {

    private final BikeRepository bikeRepository;

    public BikeGetService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    public Flux<Bike> getBike() {
        return bikeRepository.findAll();
    }
}
