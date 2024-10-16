package com.zeotop.assignment.weathermonitoring;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WeatherSummary {
    private double avgTemp;
    private double maxTemp;
    private double minTemp;
    private String dominantCondition;

    public WeatherSummary(double avgTemp, double maxTemp, double minTemp, String dominantCondition) {
        this.avgTemp = avgTemp;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.dominantCondition = dominantCondition;
    }

    // Save this object to your database
    public void saveToDatabase() {
    }
    public String findDominantCondition(List<String> conditions) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String condition : conditions) {
            frequencyMap.put(condition, frequencyMap.getOrDefault(condition, 0) + 1);
        }
        return Collections.max(frequencyMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

}
