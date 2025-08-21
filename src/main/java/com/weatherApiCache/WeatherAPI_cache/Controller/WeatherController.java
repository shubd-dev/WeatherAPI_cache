package com.weatherApiCache.WeatherAPI_cache.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.weatherApiCache.WeatherAPI_cache.Service.weatherService;
import com.weatherApiCache.WeatherAPI_cache.model.weatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private weatherService weatherService;

    public WeatherController(weatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}")
    public ResponseEntity<weatherData> getWeatherByCity(@PathVariable String city) throws JsonProcessingException {
        weatherData data = weatherService.getWeatherData(city);

        //to handle 404 responses
        if(data == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(data);
    }

}
