package com.henricoleodra.springbootmongodb.service;

import org.json.JSONObject;

public interface PeopleService {
    public void insertProducts(JSONObject data);

    public JSONObject getProducts(String id);

    public JSONObject explainQuery();
}
