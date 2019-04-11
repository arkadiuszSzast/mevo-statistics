package com.mevo.statistics.mevo.station.domain;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.querydsl.ReactiveQuerydslPredicateExecutor;

public interface StationRepository extends ReactiveMongoRepository<Station, ObjectId>, ReactiveQuerydslPredicateExecutor<Station> {
}
