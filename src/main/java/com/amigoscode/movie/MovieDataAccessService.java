package com.amigoscode.movie;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MovieDataAccessService implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    public MovieDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movie> selectMovies() {
        var sql = "SELECT id,name,releaseDate  from movie";
        return jdbcTemplate.query(sql, new MovieRowMapper());
    }

    @Override
    public int insertMovie(Movie movie) {
        var sql = "INSERT INTO movie(id,name, releaseDate) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, movie.getId(),movie.getName(), movie.getReleaseDate());
    }

    @Override
    public int deleteMovie(String id) {
        var sql = "DELETE FROM movie where id = ?";
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public Optional<Movie> selectMovieById(String id) {
        String sql = "SELECT id,name,releaseDate  from movie where id = ?";
        return jdbcTemplate.query(sql, new MovieRowMapper(), id).stream().findFirst();
    }
}
