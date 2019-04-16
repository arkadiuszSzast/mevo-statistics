package com.mevo.statistics.mevo.data.bike;

import com.mevo.statistics.mevo.bike.domain.Bike;
import com.mevo.statistics.mevo.bike.domain.BikeRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class BikeSaveService {

    private final BikeRepository bikeRepository;

    public BikeSaveService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    public void save(Flux<Bike> bikes) {
        bikeRepository.saveAll(bikes).subscribe();
    }
}
