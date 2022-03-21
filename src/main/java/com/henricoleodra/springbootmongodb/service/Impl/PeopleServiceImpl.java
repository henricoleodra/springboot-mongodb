package com.henricoleodra.springbootmongodb.service.Impl;

import java.util.ArrayList;
import java.util.List;

import com.henricoleodra.springbootmongodb.service.PeopleService;
import com.henricoleodra.springbootmongodb.utils.MongoDBStore;
import com.henricoleodra.springbootmongodb.utils.QueryFilter;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service("PeopleService")
public class PeopleServiceImpl implements PeopleService {

    @Override
    public void insertProducts(JSONObject data) {
        MongoDBStore store = new MongoDBStore("people", "detail");
        store.insertDocument(data);
    }

    @Override
    public JSONObject getProducts(String id) {
        MongoDBStore store = new MongoDBStore("people", "detail");
        return store.findDocument(id);
    }

    @Override
    public JSONObject explainQuery(){
        MongoDBStore store = new MongoDBStore("people", "detail");
        List<QueryFilter> filter = new ArrayList<QueryFilter>();
        filter.add(new QueryFilter("first_name", "hai", "equal"));
        filter.add(new QueryFilter("last_name", "dude", "equal"));
        filter.add(new QueryFilter("age", "1", "greaterThan"));
        return store.findDocumentExplain("and", filter);
    }
}
