package com.baitap.session09.Dao;

import com.baitap.session09.modal.Movie;
import com.baitap.session09.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MoviesDaoImp implements MoviesDao {
    @Override
    public List<Movie> getMovies() {
        Connection con = null;
        CallableStatement cstmt = null;
        List<Movie> movies = new ArrayList<Movie>();
        try {
            con = ConnectionDB.openConnection();
            cstmt = con.prepareCall("{call get_all_movies()}");
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setId(rs.getInt("id"));
                movie.setTitle(rs.getString("title"));
                movie.setDirector(rs.getString("director"));
                movie.setGenre(rs.getString("genre"));
                movie.setDescription(rs.getString("description"));
                movie.setDuration(rs.getInt("duration"));
                movie.setLanguage(rs.getString("language"));
                movies.add(movie);
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return movies;
    }

    @Override
    public Movie getMovie(int id) {
        Connection con = null;
        CallableStatement cstmt = null;
        Movie movie = null;
        try {
            con = ConnectionDB.openConnection();
            cstmt = con.prepareCall("{call get_detail_movie(?)}");
            cstmt.setInt(1, id);
            ResultSet rs = cstmt.executeQuery();
            if (rs.next()) {
                movie = new Movie();
                movie.setId(rs.getInt("id"));
                movie.setTitle(rs.getString("title"));
                movie.setDirector(rs.getString("director"));
                movie.setGenre(rs.getString("genre"));
                movie.setDescription(rs.getString("description"));
                movie.setDuration(rs.getInt("duration"));
                movie.setLanguage(rs.getString("language"));
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return movie;
    }
}
