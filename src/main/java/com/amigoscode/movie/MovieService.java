package com.amigoscode.movie;

import com.amigoscode.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieDao movieDao;

    public MovieService(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    public List<Movie> getMovies() {
        return movieDao.selectMovies();
    }

    public void addNewMovie(Movie movie) {
        int result = movieDao.insertMovie(movie);
        if (result != 1)
            throw new IllegalArgumentException("Oops something went wrong");
    }

    public Movie getMovie(String id) {
        return movieDao.selectMovieById(id).orElseThrow(() -> new NotFoundException("not found a movie with id : " + id));
    }

    public void removeMovie(String id) {
        movieDao.selectMovieById(id).ifPresentOrElse(movie -> {
            int result = movieDao.deleteMovie(movie.getId());
            if (result != 1) {
                throw new IllegalArgumentException("oops, could not delete movie");
            }
        }, () -> new NotFoundException(String.format("Film with id % is not found", id)));
    }
}
