package com.example.selfcert.repositories.api;

import com.example.selfcert.framework.IntegrationTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import static org.assertj.core.api.Assertions.*;

@Tag("integration")
class TimeServerGatewayTest extends IntegrationTest {

    @Autowired
    private TimeServerGateway gateway;

    @Test
    void shouldFetchDateForValidZone()  {
        assertThat(gateway.getDate("john@wick.com").get()).isNotNull();
    }

}