package com.zeotop.assignment.weathermonitoring;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class WeatherService {

    private static final String API_KEY = "my_api_key";
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=";

    public JsonNode getWeatherData(String city) throws Exception {
        String urlString = BASE_URL + city + "&appid=" + API_KEY;
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        if (responseCode == 200) {
            String inline = "";
            Scanner sc = new Scanner(url.openStream());

            while (sc.hasNext()) {
                inline += sc.nextLine();
            }
            sc.close();

            ObjectMapper mapper = new ObjectMapper();
            return mapper.readTree(inline); // JSON weather data as a tree structure
        } else {
            throw new RuntimeException("Failed to fetch weather data: " + responseCode);
        }
    }
}
