package com.henricoleodra.springbootmongodb.service.Impl;

import com.henricoleodra.springbootmongodb.service.PeopleService;
import com.henricoleodra.springbootmongodb.utils.MongoDBStore;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service("PeopleService")
public class PeopleServiceImpl implements PeopleService {

    @Override
    public void insertProducts(JSONObject data) {
        MongoDBStore store = new MongoDBStore();
        store.insertDocument(data);
    }

    @Override
    public JSONObject getProducts(String id) {
        MongoDBStore store = new MongoDBStore();
        return store.findDocument(id);
    }
}
