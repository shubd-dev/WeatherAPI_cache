package com.weatherApiCache.WeatherAPI_cache.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class weatherData {
    private String address;
    private Long epoch;
    private Double temp;

    private JsonNode rawData;



    public weatherData() {}

    public weatherData(String address, Long epoch, Double temp) {
        this.address = address;
        this.epoch = epoch;
        this.temp = temp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getEpoch() {
        return epoch;
    }

    public void setEpoch(Long epoch) {
        this.epoch = epoch;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "weatherData{" +
                "address='" + address + '\'' +
                ", epoch=" + epoch +
                ", temp=" + temp +
                '}';
    }
}
