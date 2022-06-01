# Java Microservice - Self Certification

This is a demo of how java microservices can can be self-certified with a component level test suite of
functional, integration and unit tests.

## Flow

```
User Controller --> User Service --> IDS API Connector --> Identity Server
                                 --> User DB Connector --> Database
```

## How to run locally

```shell
docker run -d \
--name postgres-self-cert \
-e POSTGRES_PASSWORD=mysecretpassword \
-e PGDATA=/var/lib/postgresql/data/pgdata \
-p 5432:5432 \
-v /Users/chandima/Dev/db:/var/lib/postgresql/data \
postgres
```