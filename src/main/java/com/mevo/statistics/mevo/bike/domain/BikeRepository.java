package com.mevo.statistics.mevo.bike.domain;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.querydsl.ReactiveQuerydslPredicateExecutor;

public interface BikeRepository extends ReactiveMongoRepository<Bike, String>, ReactiveQuerydslPredicateExecutor<Bike> {

}
