package com.example.LearningSpringBoot.service;

import com.example.LearningSpringBoot.Entity.GeoApiResponse;
import com.example.LearningSpringBoot.Entity.GeoLocation;
import com.example.LearningSpringBoot.Entity.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Fetch latitude and longitude from city and country
     */
    public GeoLocation location(String city, String country) {
        String url = "https://geocoding-api.open-meteo.com/v1/search?name=" + city + "&country=" + country;
        GeoApiResponse response = restTemplate.getForObject(url, GeoApiResponse.class);

        if (response != null && response.getResults() != null && !response.getResults().isEmpty()) {
            return response.getResults().get(0);  // Use the first matched location
        } else {
            return null;
        }
    }

    /**
     * Fetch weather based on latitude and longitude
     */
    public Weather getWeatherByCoordinates(double latitude, double longitude) {
        String url = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude +
                     "&longitude=" + longitude +
                     "&current=temperature_2m,precipitation";

        return restTemplate.getForObject(url, Weather.class);
    }
}
