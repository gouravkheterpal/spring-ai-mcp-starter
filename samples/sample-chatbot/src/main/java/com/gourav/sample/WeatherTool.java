package com.gourav.sample;

import com.fasterxml.jackson.databind.JsonNode;
import com.gourav.mcp.core.McpTool;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherTool {

    private final RestTemplate restTemplate;

    private static final String API_KEY =
            "f1ba2b7d603f3865dff340c7156f9aeb";

    public WeatherTool(
            RestTemplate restTemplate
    ) {

        this.restTemplate = restTemplate;
    }

    @McpTool(
            name = "weather",
            description = "Get real weather details"
    )
    public String getWeather(String city) {

        try {

            String url =
                    "https://api.openweathermap.org/data/2.5/weather?q="
                            + city
                            + "&appid="
                            + API_KEY
                            + "&units=metric";

            JsonNode response =
                    restTemplate.getForObject(
                            url,
                            JsonNode.class
                    );

            double temperature =
                    response.get("main")
                            .get("temp")
                            .asDouble();

            String description =
                    response.get("weather")
                            .get(0)
                            .get("description")
                            .asText();

            return city
                    + ": "
                    + temperature
                    + "°C, "
                    + description;

        } catch (Exception e) {

            e.printStackTrace();

            return "Failed to fetch weather";
        }
    }
}