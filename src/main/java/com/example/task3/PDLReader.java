package com.example.task3;

import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PDLReader {
    public static void main(String[] args) throws IOException {
        String API_KEY = "";
        //Put API key for people data labs API
        //URL url = new URL("https://lnup.edu.ua");
        URL url = new URL("https://api.peopledatalabs.com/v5/company/enrich?website=lnup.edu.ua");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //connection.setRequestMethod("GET");
        connection.setRequestProperty("X-Api-Key", API_KEY);
        connection.connect();
        String text = new Scanner(connection.getInputStream()).useDelimiter("\\Z").next();
        JSONObject jsonObject = new JSONObject(text);
        Company company = new Company(jsonObject.get("name"), jsonObject.get("description"), jsonObject.get("photo"));
        System.out.println(text);
    }
}
