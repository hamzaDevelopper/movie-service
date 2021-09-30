CREATE TABLE movie (
                       id TEXT PRIMARY KEY,
                       name TEXT NOT NULL,
                       releaseDate TEXT NOT NULL,
                       unique (name)
);
