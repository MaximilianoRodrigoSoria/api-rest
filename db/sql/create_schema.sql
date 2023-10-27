CREATE TABLE history (
                               id SERIAL PRIMARY KEY,
                               endpoint VARCHAR(255) NOT NULL,
                               request TEXT NOT NULL,
                               response TEXT NOT NULL,
                               timestamp TIMESTAMP NOT NULL,
                               success BOOLEAN NOT NULL
);
