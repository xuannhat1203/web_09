package com.baitap.session09.Service;

import com.baitap.session09.modal.Movie;

import java.util.List;

public interface MoviesService {
    List<Movie> getMovies();
    Movie getMovie(int id);
}
