package com.baitap.session09.Dao;

import com.baitap.session09.modal.Movie;

import java.util.List;

public interface MoviesDao {
    List<Movie> getMovies();
    Movie getMovie(int id);
}
