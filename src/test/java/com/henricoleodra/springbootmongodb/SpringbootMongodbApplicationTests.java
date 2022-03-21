package com.henricoleodra.springbootmongodb;

import org.bson.BsonDocument;
import org.bson.conversions.Bson;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.gt;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mongodb.MongoClientSettings;

@SpringBootTest
class SpringbootMongodbApplicationTests {

	@Test
	void contextLoads() {
		// Bson filter = and(eq("field1", "value"), gt("field2", "value"));
		// BsonDocument bsonDocument = filter.toBsonDocument(BsonDocument.class, MongoClientSettings.getDefaultCodecRegistry());

		// Bson optionalFilter = eq("field3", "value");
		// BsonDocument optionalBsonDocument = optionalFilter.toBsonDocument(BsonDocument.class, MongoClientSettings.getDefaultCodecRegistry());

		// bsonDocument.append("field3", optionalBsonDocument.get("field3"));

		// Bson completeFilter = and(eq("field1", "value"), gt("field2", "value"), eq("field3", "value"));
		// BsonDocument compleBsonDocument = completeFilter.toBsonDocument(BsonDocument.class, MongoClientSettings.getDefaultCodecRegistry());


	}

}
