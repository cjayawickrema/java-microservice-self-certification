package com.example.selfcert.framework;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
/**
 * This class is only meant for Framework level abstractions.
 */
public abstract class IntegrationTest {

    /**
     * TestEnvironment holds the test containers relevant for this application/component.
     * Note that the static context is used to maintain suite level isolation and speed up execution.
     */
    protected static final TestEnvironment TEST_ENVIRONMENT = new TestEnvironment();


}
