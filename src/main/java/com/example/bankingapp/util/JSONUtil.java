package com.example.bankingapp.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class JSONUtil {

    public static ArrayList<JSONObject> fromJSONToArrayList(FileReader file) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(file);

        ArrayList<JSONObject> jsonArray = json;
        return jsonArray;
    }
}
