package com.mevo.statistics.mevo.bike.domain;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.querydsl.ReactiveQuerydslPredicateExecutor;

public interface BikeRepository extends ReactiveMongoRepository<Bike, ObjectId>, ReactiveQuerydslPredicateExecutor<Bike> {

}
