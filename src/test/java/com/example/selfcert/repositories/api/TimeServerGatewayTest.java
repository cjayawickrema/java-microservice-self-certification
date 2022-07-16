package com.example.selfcert.repositories.api;

import com.example.selfcert.framework.IntegrationTest;
import com.example.selfcert.models.DaylightInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@Tag("integration")
class TimeServerGatewayTest extends IntegrationTest {

    @Autowired
    private TimeServerGateway gateway;

    @Test
    void shouldFetchDateForValidLocation() {
        Optional<DaylightInfo> daylightInfo = gateway.getDaylighInfo(79.938356f, 6.837265f);
        assertThat(daylightInfo).isPresent();
        assertThat(daylightInfo.get().getSunrise()).isNotNull();
        assertThat(daylightInfo.get().getSunset()).isNotNull();
    }

}