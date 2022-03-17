package com.henricoleodra.springbootmongodb.utils;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import org.json.JSONObject;

public class MongoDBStore {
    private MongoClient client;

    public MongoDBStore(){
        client = new MongoDBConnection().getClient();
    }

    public void insertDocument(JSONObject data){
        MongoCollection<Document> collection = client.getDatabase("products").getCollection("detail");
        Document document = new Document();
        for (String keyStr : data.keySet()) {
            Object keyValue = data.get(keyStr);
            document.append(keyStr, keyValue);
        }
        collection.insertOne(document);
    }
}
