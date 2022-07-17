package com.example.selfcert.services;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class LocalTimeService {

    public LocalTime now(ZoneId zone) {
        return LocalTime.now(ZoneOffset.UTC);
    }

}
