package com.amigoscode.movie;

import java.util.List;
import java.util.Optional;

public interface MovieDao {
    List<Movie> selectMovies();
    int insertMovie(Movie movie);
    int deleteMovie(String id);
    Optional<Movie> selectMovieById(String id);
}
