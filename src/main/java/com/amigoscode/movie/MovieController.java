package com.amigoscode.movie;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> listMovies()
    {
        return movieService.getMovies();
    }

    @GetMapping("{id}")
    public Movie getMovie(@PathVariable("id") String id)
    {
        return movieService.getMovie(id);
    }

    @PostMapping
    public void addMovie(@RequestBody Movie movie)
    {
        movieService.addNewMovie(movie);
    }

    @DeleteMapping("{id}")
    public void deleteMovie(@PathVariable("id") String id)
    {
        movieService.removeMovie(id);
    }

}
