package com.henricoleodra.springbootmongodb.utils;

import com.mongodb.MongoClient;

public class MongoDBConnection {
    private MongoClient client;

    public MongoDBConnection(){
        client = new MongoClient("localhost", 27017);
    }

    public MongoClient getClient(){
        return client;
    }
}
