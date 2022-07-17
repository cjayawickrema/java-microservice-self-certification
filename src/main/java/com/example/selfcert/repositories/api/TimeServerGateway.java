package com.example.selfcert.repositories.api;

import com.example.selfcert.models.DaylightInfo;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Repository
public class TimeServerGateway {
    private RestTemplate restTemplate = new RestTemplate();

    public Optional<DaylightInfo> getDaylighInfo(float lng, float lat) {
        try {
            String url = String.format("https://api.sunrise-sunset.org/json?lat=%f&lng=%f&date=today", lat, lng); // TODO externalize url
            System.out.println("calling URL: " + url); // TODO configure loggers
            ResponseEntity<JsonNode> response =
                    restTemplate.exchange(url, HttpMethod.GET, null, JsonNode.class);
            JsonNode map = response.getBody().get("results");
            LocalTime sunrise = parseLocalTime(map.get("sunrise").asText());
            LocalTime sunset = parseLocalTime(map.get("sunset").asText());
            return Optional.of(new DaylightInfo(sunrise, sunset));
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println(ex); // TODO log errors
            return Optional.empty();
        }
    }

    private LocalTime parseLocalTime(String localTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm:ss a");
        LocalTime time = LocalTime.parse(localTime, formatter);
        return time;
    }

}
