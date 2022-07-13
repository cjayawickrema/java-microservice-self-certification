package com.example.selfcert.framework;

import org.testcontainers.containers.PostgreSQLContainer;

public class TestEnvironment {

    private PostgreSQLContainer databaseContainer;

    /**
     * PostgresSQLContainer internally ignores env vars and always uses following creds.
     */
    private static final String POSTGRES_PASSWORD = "test";
    private static final String POSTGRES_USERNAME = "test";
    private static final String POSTGRES_DATABASE = "test";

    public TestEnvironment() {
        setupDatabaseContainer();
    }

    private void setupDatabaseContainer() {
        databaseContainer = new PostgreSQLContainer("postgres");
        databaseContainer.start();
        String dbServerHost = databaseContainer.getHost();
        Integer dbServerPort = databaseContainer.getFirstMappedPort();
        System.out.println("DB container running at: " + dbServerHost + ":" + dbServerPort);

        // overriding db creds
        System.setProperty("spring.datasource.url", String.format("jdbc:postgresql://%s:%d/%s", dbServerHost, dbServerPort, POSTGRES_DATABASE));
        System.setProperty("spring.datasource.password", POSTGRES_PASSWORD);
        System.setProperty("spring.datasource.username", POSTGRES_USERNAME);
    }

}
