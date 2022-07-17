package com.example.selfcert.services;

import com.example.selfcert.models.DaylightInfo;
import com.example.selfcert.repositories.api.TimeServerGateway;
import com.example.selfcert.repositories.db.UserRepository;
import com.example.selfcert.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final TimeServerGateway timeServerGateway;
    private final UserRepository userRepository;
    private final LocalTimeService localTimeService;

    public User getUserInformation(Long id) {
        User user = userRepository.findUser(id);

        Optional<DaylightInfo> daylightInfo = timeServerGateway.getDaylighInfo(user.getLongitude(), user.getLatitude());
        if (daylightInfo.isPresent()) {
            user.setDarkTheme(!isDaytime(daylightInfo.get()));
        } else {
            user.setDarkTheme(false);
        }

        return user;
    }

    private boolean isDaytime(DaylightInfo daylightInfo) {
        LocalTime now = localTimeService.now(ZoneOffset.UTC);
        return now.isAfter(daylightInfo.getSunrise()) && now.isBefore(daylightInfo.getSunset());
    }
}


// 5pm