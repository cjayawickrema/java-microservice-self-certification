package com.example.selfcert.repositories.api;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Repository
public class TimeServerGateway {
    private RestTemplate restTemplate = new RestTemplate();
    private final static int EPOCH_MULTIPLIER = 1000;
    private final Random r = new Random();

    public Optional<Date> getDate(String zone) {
        ParameterizedTypeReference<HashMap<String, String>> responseType = new ParameterizedTypeReference<HashMap<String, String>>() {
        };
        RequestEntity<Void> request = RequestEntity.get("http://worldtimeapi.org/api/timezone/" + zone).accept(MediaType.APPLICATION_JSON).build();
        Map<String, String> jsonDictionary = restTemplate.exchange(request, responseType).getBody();
        return Optional.of(new Date(Long.parseLong(jsonDictionary.get("unixtime")) * EPOCH_MULTIPLIER - (r.nextInt(1000 * 60 * 60 * 24 * 5))));
    }
}
