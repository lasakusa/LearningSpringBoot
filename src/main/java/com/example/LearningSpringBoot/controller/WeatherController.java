package com.example.LearningSpringBoot.controller;

import com.example.LearningSpringBoot.Entity.GeoLocation;
import com.example.LearningSpringBoot.Entity.Weather;
import com.example.LearningSpringBoot.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/location-api-result")
    public String fetchLocation(@RequestParam(value = "name") String name,
                                @RequestParam(value = "country") String country,
                                Model model) {

        GeoLocation location = weatherService.location(name, country);

        if (location != null) {
            model.addAttribute("locationInformation", location);
        } else {
            model.addAttribute("error", "No result found");
        }

        return "location-ui";
    }
    
    @GetMapping("/location-api")
    public String showSearchForm() {
        return "location-search";
    }
    
//    @GetMapping("/weather-api-result")
//    public String getWeatherFromCoordinates(@RequestParam("latitude") double latitude,
//                                            @RequestParam("longitude") double longitude,
//                                            Model model) {
//
//        Weather weather = weatherService.getWeatherByCoordinates(latitude, longitude);
//
//        if (weather != null && weather.getCurrent() != null) {
//            model.addAttribute("temperature", weather.getCurrent().getTemperature_2m());
//            model.addAttribute("precipitation", weather.getCurrent().getPrecipitation());
//            model.addAttribute("time", weather.getCurrent().getTime());
//            model.addAttribute("latitude", weather.getLatitude());
//            model.addAttribute("longitude", weather.getLongitude());
//            return "weather-ui";
//        } else {
//            model.addAttribute("error", "Unable to retrieve weather information.");
//            return "weather-ui";
//        }
//    }
    
    @GetMapping("/weather-from-city")
    public String getWeatherFromCity(@RequestParam("name") String city, Model model) {
        GeoLocation location = weatherService.location(city, ""); // no country

        if (location == null) {
            model.addAttribute("error", "City not found.");
            return "weather-ui";
        }

        Weather weather = weatherService.getWeatherByCoordinates(location.getLatitude(), location.getLongitude());

        if (weather == null || weather.getCurrent() == null) {
            model.addAttribute("error", "Weather data not available.");
            return "weather-ui";
        }

        model.addAttribute("city", location.getName());
        model.addAttribute("country", location.getCountry());
        model.addAttribute("latitude", weather.getLatitude());
        model.addAttribute("longitude", weather.getLongitude());
        model.addAttribute("temperature", weather.getCurrent().getTemperature_2m());
        model.addAttribute("precipitation", weather.getCurrent().getPrecipitation());
        model.addAttribute("time", weather.getCurrent().getTime());

        return "weather-ui";
    }



}
