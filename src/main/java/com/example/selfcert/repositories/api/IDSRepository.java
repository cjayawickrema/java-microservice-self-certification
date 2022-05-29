package com.example.selfcert.repositories.api;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Optional;

@Repository
public class IDSRepository {
    private RestTemplate restTemplate = new RestTemplate();

    public Optional<Date> getLastLoggedInTime(String email) {
        return Optional.of(new Date()); // TODO call http://worldtimeapi.org/api/timezone/Asia/Colombo
    }
}
