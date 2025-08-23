package com.weatherApiCache.WeatherAPI_cache.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherApiCache.WeatherAPI_cache.model.weatherData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class weatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.baseUrl}")
    private String apiUrl;

    private final RestClient restClient;

    ObjectMapper mapper = new ObjectMapper();
    weatherData weatherOfCity;
    String response;


    public weatherService(RestClient.Builder restClientBuilder){
        this.restClient = restClientBuilder.baseUrl(apiUrl).build();
    }

    @Cacheable(value = "weatherCache", key = "#name")
    public weatherData getWeatherData(String name) throws JsonProcessingException {



        String url = UriComponentsBuilder.fromUriString(apiUrl)
                .pathSegment(name)
                .queryParam("unitGroup", "metric")
                .queryParam("key", apiKey)
                .queryParam("contentType", "json")
                .toUriString();

        // System.out.println(url);


        try {
            response = restClient.get()
                    .uri(url)
                    .retrieve()
                    .body(String.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        JsonNode rootNode = mapper.readTree(response);

        weatherOfCity = new weatherData(
                rootNode.get("resolvedAddress").asText(),
                rootNode.get("currentConditions").get("datetimeEpoch").asLong(),
                rootNode.get("currentConditions").get("temp").asDouble()
        );
        return weatherOfCity;

    }
}
