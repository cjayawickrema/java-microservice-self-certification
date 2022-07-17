package com.example.selfcert.services;

import com.example.selfcert.models.DaylightInfo;
import com.example.selfcert.models.User;
import com.example.selfcert.repositories.api.TimeServerGateway;
import com.example.selfcert.repositories.db.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@Tag("unit")
@RunWith(MockitoJUnitRunner.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;
    @Mock
    private TimeServerGateway timeServerGateway;
    @Mock
    private UserRepository userRepository;
    @Mock
    private LocalTimeService localTimeService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        // DB repo mock
        User userMock = new User(1L, "John Wick", "john@wick.com", 79.938356f, 6.837265f, false);
        Mockito.when(userRepository.findUser(1L)).thenReturn(userMock);

        // gateway mock
        DaylightInfo daylightInfo = new DaylightInfo(LocalTime.of(6, 0), LocalTime.of(18, 0));
        Mockito.when(timeServerGateway.getDaylighInfo(userMock.getLongitude(), userMock.getLatitude())).thenReturn(Optional.of(daylightInfo));
    }

    @Test
    void shouldGetDarkThemInNight() {
        // current time mock
        Mockito.when(localTimeService.now(ZoneOffset.UTC)).thenReturn(LocalTime.of(20, 0));
        User user = userService.getUserInformation(1L);
        assertThat(user.isDarkTheme()).isTrue();
    }

    @Test
    void shouldNotGetDarkThemInDaytime() {
        // current time mock
        Mockito.when(localTimeService.now(ZoneOffset.UTC)).thenReturn(LocalTime.of(10, 0));
        User user = userService.getUserInformation(1L);
        assertThat(user.isDarkTheme()).isFalse();
    }
}