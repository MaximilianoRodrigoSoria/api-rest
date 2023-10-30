CREATE TABLE history (
                               id SERIAL PRIMARY KEY,
                               endpoint VARCHAR(255) NOT NULL,
                               responseBody TEXT NOT NULL,
                               requestBody TEXT NOT NULL,
                               status TEXT NOT NULL,
                               method TEXT NOT NULL,
                               timestamp TIMESTAMP NOT NULL,
                               success BOOLEAN NOT NULL
);
