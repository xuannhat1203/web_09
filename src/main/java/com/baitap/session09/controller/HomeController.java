package com.baitap.session09.controller;
import com.baitap.session09.Service.MoviesServiceImp;
import com.baitap.session09.modal.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class HomeController {
    public MoviesServiceImp moviesServiceImp = new MoviesServiceImp();

    @GetMapping("/home")
    public String home(Model model) {
        List<Movie> movieList = moviesServiceImp.getMovies();
        model.addAttribute("movieList", movieList);
        return "home";
    }

    @GetMapping("/movie-detail")
    public String detailMovie(@RequestParam("id") int id, Model model) {
        List<Movie> movieList = moviesServiceImp.getMovies();
        Movie mv = null;
        for (Movie m : movieList) {
            if (m.getId() == id) {
                mv = m;
                break;
            }
        }
        if (mv != null) {
            model.addAttribute("movie", mv);
            return "detailMovie";
        }
        return "redirect:/home";
    }
}

