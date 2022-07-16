CREATE TABLE "user"
(
    id    serial PRIMARY KEY,
    email VARCHAR(100) UNIQUE  NOT NULL,
    name  VARCHAR(255) NOT NULL,
    longitude float,
    latitude float
);