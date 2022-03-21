package com.henricoleodra.springbootmongodb.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;

public class QueryFilter {
    private String key;
    private String value;
    private String operation;
    private static Map<String, String> operationMap;

    static {
        operationMap = new HashMap<String, String>();
        operationMap.put("greaterThan", "$gt");
    }

    public QueryFilter(String key, String value, String operation){
        this.key = key;
        this.value = value;
        this.operation = operation;
    }

    public String getKey(){
        return key;
    }

    public String getValue(){
        return value;
    }

    public String getOperation(){
        return operation;
    }

    public static List<Document> translateQueryFilters(List<QueryFilter> queryFilters){
        List<Document> result = new ArrayList<Document>();
        queryFilters.forEach((queryFilter) -> {
            if(queryFilter.getOperation().equalsIgnoreCase("equal")){
                result.add(new Document(queryFilter.getKey(), queryFilter.getValue()));
            }
            else{
                result.add(new Document(queryFilter.getKey(), new Document(operationMap.get(queryFilter.getOperation()), Integer.parseInt(queryFilter.getValue()))));
            }
        });
        return result;
    }
}
