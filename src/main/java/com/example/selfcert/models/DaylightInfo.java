package com.example.selfcert.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class DaylightInfo {
    private LocalTime sunrise;
    private LocalTime sunset;
}
