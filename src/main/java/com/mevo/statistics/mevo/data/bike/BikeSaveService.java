package com.mevo.statistics.mevo.data.bike;

import com.mevo.statistics.mevo.bike.domain.Bike;
import com.mevo.statistics.mevo.bike.domain.BikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeSaveService {

    private final BikeRepository bikeRepository;

    public BikeSaveService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    public void save(List<Bike> bikes) {
        bikeRepository.saveAll(bikes).subscribe();
    }
}
