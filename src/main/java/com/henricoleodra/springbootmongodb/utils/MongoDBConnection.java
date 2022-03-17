package com.henricoleodra.springbootmongodb.utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoDBConnection {
    private MongoClient client;

    public MongoDBConnection() {
        client = MongoClients.create();
    }

    public MongoClient getClient() {
        return client;
    }
}
