package com.weatherApiCache.WeatherAPI_cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class WeatherApiCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApiCacheApplication.class, args);
	}

}
