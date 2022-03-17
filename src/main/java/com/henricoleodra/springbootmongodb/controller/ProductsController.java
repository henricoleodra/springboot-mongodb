package com.henricoleodra.springbootmongodb.controller;

import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.henricoleodra.springbootmongodb.service.PeopleService;
import com.henricoleodra.springbootmongodb.utils.MongoDBConnection;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductsController {
    
    @Autowired
    PeopleService service;

    @PostMapping("")
    public void  add(@RequestBody String payload){
        System.out.println(payload);
        JSONObject reqBody = new JSONObject(payload);
        service.insertProducts(reqBody);
        // MongoDBConnection connection = new MongoDBConnection();
    }
}
