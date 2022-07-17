package com.example.selfcert.services;

import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

@Service
public class LocalTimeService {

    public LocalTime now(ZoneId zone) {
        return LocalTime.now(ZoneOffset.UTC);
    }

}
