package com.baitap.session09.Service;

import com.baitap.session09.Dao.MoviesDao;
import com.baitap.session09.Dao.MoviesDaoImp;
import com.baitap.session09.modal.Movie;

import java.util.List;

public class MoviesServiceImp implements MoviesService {
    public MoviesDao moviesDao;
    public MoviesServiceImp() {
        moviesDao = new MoviesDaoImp();
    }
    @Override
    public List<Movie> getMovies() {
        return moviesDao.getMovies();
    }

    @Override
    public Movie getMovie(int id) {
        return moviesDao.getMovie(id);
    }
}
