package com.amigoscode.movie;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MovieRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Movie(rs.getString("id"), rs.getString("name"), rs.getString("releaseDate"));

    }
}
