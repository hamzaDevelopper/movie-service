package com.amigoscode.movie;

import com.amigoscode.exception.ApiException;
import com.amigoscode.exception.MovieNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> listMovies() {
        return movieService.getMovies();
    }

    @GetMapping("{id}")
    public Movie getMovie(@PathVariable("id") String id) {
        return movieService.getMovie(id);
    }

    @PostMapping
    public void addMovie(@RequestBody Movie movie) {
        movieService.addNewMovie(movie);
    }

    @DeleteMapping("{id}")
    public void deleteMovie(@PathVariable("id") String id) {
        movieService.removeMovie(id);
    }

    @GetMapping("/exception")
    public Movie exceptionMovie() {
        throw new MovieNotFoundException("oops Something went Wrong !!! ");
    }

    @ExceptionHandler(value = MovieNotFoundException.class)
    public ResponseEntity<ApiException> handleMovieNotFoundException(MovieNotFoundException e) {

        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException apiException = ApiException.builder()
                .ErrorCode("MOVIE_NOT_FOUND")
                .httpStatus(badRequest)
                .message(e.getMessage())
                .timestamp(ZonedDateTime.now(ZoneId.of("Z")))
                .build();

        return new ResponseEntity<>(apiException, badRequest);
    }

}
