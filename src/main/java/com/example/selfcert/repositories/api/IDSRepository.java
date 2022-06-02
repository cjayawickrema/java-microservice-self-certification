package com.example.selfcert.repositories.api;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class IDSRepository {
    private RestTemplate restTemplate = new RestTemplate();
    private final static int EPOCH_MULTIPLIER = 1000;

    public Optional<Date> getLastLoggedInTime(String email) {
        ParameterizedTypeReference<HashMap<String, String>> responseType = new ParameterizedTypeReference<HashMap<String, String>>() {
        };
        RequestEntity<Void> request = RequestEntity.get("http://worldtimeapi.org/api/timezone/Asia/Colombo").accept(MediaType.APPLICATION_JSON).build();
        Map<String, String> jsonDictionary = restTemplate.exchange(request, responseType).getBody();
        return Optional.of(new Date(Long.parseLong(jsonDictionary.get("unixtime")) * EPOCH_MULTIPLIER));
    }
}
