CREATE TABLE "user"
(
    id    serial PRIMARY KEY,
    email VARCHAR(50) UNIQUE  NOT NULL,
    name  VARCHAR(255) UNIQUE NOT NULL
);