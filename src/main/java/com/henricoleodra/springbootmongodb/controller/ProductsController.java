package com.henricoleodra.springbootmongodb.controller;

import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.henricoleodra.springbootmongodb.service.PeopleService;
import com.henricoleodra.springbootmongodb.utils.MongoDBConnection;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public void add(@RequestBody String payload) {
        JSONObject reqBody = new JSONObject(payload);
        service.insertProducts(reqBody);
        // MongoDBConnection connection = new MongoDBConnection();
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> get(@PathVariable String id) {
        JSONObject product = service.getProducts(id);
        System.out.println(product.toString());
        return new ResponseEntity<String>(product.toString(), HttpStatus.OK);
    }
}
