package com.henricoleodra.springbootmongodb.utils;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.json.JSONObject;

public class MongoDBConnection {
    private MongoClient client;

    public MongoDBConnection() {
        client = MongoClients.create();
    }

    public MongoDBConnection(JSONObject config) {
        String ip = config.getString("ip");
        String user = config.getString("user");
        String password = config.getString("password");
        String replicaSet = config.getString("replicaSet");
        ConnectionString connectionString = new ConnectionString("mongodb://" + user + ":" + password + "@" + ip + "/?replicaSet=" + replicaSet);
        client = MongoClients.create(connectionString);
    }

    public MongoClient getClient() {
        return client;
    }
}
