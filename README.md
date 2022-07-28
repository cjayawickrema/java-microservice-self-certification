# Java Microservice - Self Certification

This is a demo of how java microservices can can be self-certified with a component level test suite of
functional, integration and unit tests.

## Flow

```
User Controller --> User Service --> Time Server Gateway --> api.sunrise-sunset.org
                                 --> User DB Connector   --> Postgres Database
```

##Pre-requsites to run or test
1. Install Docker Desktop or Docker Engine depending on your OS
2. Make sure Docker daemon is running
3. Make sure Java 11+ and Gradle 7.4+ is properly setup

## How to run locally
1. Make sure Docker is installed and running
2. Execute following command to start the DB
```shell
docker run -d \
--name postgres-self-cert \
-e POSTGRES_PASSWORD=mysecretpassword \
-e PGDATA=/var/lib/postgresql/data/pgdata \
-p 5432:5432 \
-v /Users/chandima/Dev/db:/var/lib/postgresql/data \
postgres
```
3. Execute `./gradlew bootRun` to start service

## How to test locally
1. Make sure Docker installed and running
2. Execute `./gradlew test` 