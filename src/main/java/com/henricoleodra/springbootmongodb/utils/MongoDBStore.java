package com.henricoleodra.springbootmongodb.utils;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONObject;

import static com.mongodb.client.model.Filters.eq;

public class MongoDBStore {
    private MongoClient client;

    public MongoDBStore() {
        client = new MongoDBConnection().getClient();
    }

    public void insertDocument(JSONObject data) {
        MongoCollection<Document> collection = client.getDatabase("products").getCollection("detail");
        Document document = new Document();
        for (String keyStr : data.keySet()) {
            Object keyValue = data.get(keyStr);
            document.append(keyStr, keyValue);
        }
        collection.insertOne(document);
    }

    public JSONObject findDocument(String id) {
        MongoCollection<Document> collection = client.getDatabase("products").getCollection("detail");
        // FindIterable<Document> iterable = collection.find();
        Bson projectionFields = Projections.fields(
                Projections.include("price", "name", "qty"));
        Document doc = collection.find(eq("name", "hello"))
                .projection(projectionFields)
                .sort(Sorts.ascending("price"))
                .explain();
        // .first();

        System.out.println(doc.toJson());

        System.out.println((new JSONObject(doc.toJson())).toString());

        return new JSONObject(doc.toJson());
    }
}
