package com.mevo.statistics.mevo.db.changelogs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.mevo.statistics.mevo.bike.domain.Bike;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;
import java.util.List;

@ChangeLog
public class DatabaseChangelog {

    public static final String DISCHARGED_BIKE = "/json/bike/discharged_bike.json";
    public static final String FULL_CHARGED_BIKE = "/json/bike/full_charged_bike.json";

    @ChangeSet(order = "001", id = "clear_character_collection", author = "arkadiusz.szast", runAlways = true)
    public void clearCharacterCollection() {
        mongoTemplate().dropCollection("bike");
        mongoTemplate().createCollection("bike");
    }

    @ChangeSet(order = "002", id = "add_test_characters", author = "arkadiusz.szast", runAlways = true)
    public void addExampleBikes() throws IOException {
        var objectMapper = new ObjectMapper();
        var  fullChargedBikeAsBytes = this.getClass().getResourceAsStream(DISCHARGED_BIKE).readAllBytes();
        var dischargedBikeAsBytes = this.getClass().getResourceAsStream(FULL_CHARGED_BIKE).readAllBytes();

        var fullChargedBike = objectMapper.readValue(fullChargedBikeAsBytes, Bike.class);
        var dischargedBike = objectMapper.readValue(dischargedBikeAsBytes, Bike.class);
        mongoTemplate().insertAll(List.of(fullChargedBike, dischargedBike));
    }

    private MongoClient mongo() {
        return new MongoClient(new MongoClientURI("mongodb://localhost:27017/mevo"));
    }

    private MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongo(), "mevo");
    }
}
