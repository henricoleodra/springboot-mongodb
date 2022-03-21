package com.henricoleodra.springbootmongodb.utils;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONObject;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MongoDBStore {
    private MongoClient client;
    private MongoCollection<Document> collection;

    public MongoDBStore(String databaseName, String collectionName) {
        client = new MongoDBConnection().getClient();
        collection = client.getDatabase(databaseName).getCollection(collectionName);
    }

    public MongoDBStore(JSONObject config){
        JSONObject connection = config.getJSONObject("connection");
        String databaseName = config.getString("database");
        String collectionName = config.getString("collection");
        client = new MongoDBConnection(connection).getClient();
        collection = client.getDatabase(databaseName).getCollection(collectionName);
    }

    public void insertDocument(JSONObject data) {
        Document document = new Document();
        for (String keyStr : data.keySet()) {
            Object keyValue = data.get(keyStr);
            document.append(keyStr, keyValue);
        }
        collection.insertOne(document);
        client.close();
    }

    public JSONObject findDocument(String id) {
        Bson projectionFields = Projections.fields(
                Projections.include("price", "name", "qty"));
        Document doc = collection.find(eq("name", "hello"))
                .projection(projectionFields)
                .sort(Sorts.ascending("price"))
                .explain();
        client.close();
        System.out.println(doc.toJson());

        System.out.println((new JSONObject(doc.toJson())).toString());

        return new JSONObject(doc.toJson());
    }

    public JSONObject findDocumentExplain(String operation, List<QueryFilter> filter){
        List<Document> filterList = QueryFilter.translateQueryFilters(filter);
        Document query = new Document("$"+operation, filterList);
        Document result = collection.find(query).explain();
        return new JSONObject(result.toJson());
    }

}



