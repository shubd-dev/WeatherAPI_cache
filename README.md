
# 🌤️ Weather API with Cache 

## 🚀 Project Overview
This is a **Spring Boot** application that fetches weather data for cities using the **Visual Crossing Timeline Weather API** 🌐. To improve performance and reduce repeated API calls, it uses **Redis caching** through **Spring Data Redis**. Weather data is cached with a TTL (time-to-live), ensuring fast and efficient responses.

---

## ✨ Features
- Fetches current weather data by city name 🌆
- Caches weather data using Redis for fast retrieval ⚡
- Configurable cache expiration (TTL) ⏳ (default 30 minutes)
- Uses Spring Boot’s `@Cacheable` and caching abstraction
- Easy-to-use REST endpoints for accessing weather info 🌍
- Handles API errors gracefully 🚧

---

## 🛠️ Technologies Used
- Java 17 ☕
- Spring Boot 3.x 🔥
- Spring Data Redis 🧰
- Redis (in-memory cache) 🗄️
- Visual Crossing Timeline Weather API ☁️
- Jackson for JSON serialization/deserialization 🖼️
- Maven for build and dependency management 📦

---

## 📂 Project Structure

```
src/main/java/com/weatherApiCache/WeatherAPI_cache/
├── Controller/       # REST controllers handling API requests
├── Service/          # Business logic and Redis caching
├── model/            # Weather data model classes
├── config/           # Redis and cache configuration
└── WeatherApiCacheApplication.java  # Main application entry
```

---

## 🔧 Setup Instructions

1. **Prerequisites:**
   - Java JDK 17+
   - Maven 3+
   - Redis server running locally or remotely 🖥️
   - Visual Crossing API key 🔑

2. **Configure Application:**

Set your Redis server and Visual Crossing API credentials in `src/main/resources/application.properties`:

```
spring.redis.host=localhost
spring.redis.port=6379

weather.api.key=YOUR_API_KEY_HERE
weather.api.baseUrl=https://weather.visualcrossing.com/api/...
```

3. **Build and Run:**

```
mvn clean install
mvn spring-boot:run
```

4. **Test Endpoint:**

Use a browser or tool like Postman to query:

```
GET http://localhost:8080/weather/{cityName}
```

Example:
```
GET http://localhost:8080/weather/London
```

---

## 🔍 How Caching Works
- When requesting weather for a city the first time, live data is fetched and **stored in Redis cache**.
- Subsequent requests for the same city use the cached data, **bypassing the API**, resulting in faster responses.
- Cache entries expire after **30 minutes** (configurable) to keep data fresh.

---

## 🎥 How It Works

Watch this quick tutorial to see how the Weather API Cache Application functions:

![Weather API Tutorial](screenshot_gif.gif)

---

## 📖 Learn More
Also, you can explore a related project idea and roadmap here:  
[Weather API Wrapper Service - Roadmap.sh](https://roadmap.sh/projects/weather-api-wrapper-service) 🌐

---

## 📫 Contact & Support
If you have questions or want to contribute or hire, please reach out at: **shubhamdhumale@gmail.com** 📧

---

Thank you for checking out this project! ☀️🌈