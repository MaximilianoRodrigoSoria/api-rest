CREATE TABLE history (
                               id SERIAL PRIMARY KEY,
                               endpoint VARCHAR(255) NOT NULL,
                               response TEXT NOT NULL,
                               request TEXT NOT NULL,
                               status TEXT NOT NULL,
                               method TEXT NOT NULL,
                               timestamp TIMESTAMP NOT NULL,
                               success BOOLEAN NOT NULL
);
