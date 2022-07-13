package com.example.selfcert.framework;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
/**
 * This class is only meant for Framework level abstractions.
 */
public abstract class FunctionalTest {

    /**
     * TestEnvironment holds the test containers relevant for this application/component.
     * Note that the static context is used to maintain suite level isolation and speed up execution.
     */
    protected static final TestEnvironment TEST_ENVIRONMENT = new TestEnvironment();

    @LocalServerPort
    protected int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

}
