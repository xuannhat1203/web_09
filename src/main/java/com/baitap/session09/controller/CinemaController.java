
package com.baitap.session09.controller;

import com.baitap.session09.Service.SchedualServiceImp;
import com.baitap.session09.modal.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@Controller
public class CinemaController {

    @Autowired
    private SchedualServiceImp scheduleServiceImpl;
    @GetMapping("/schedules")
    public String schedules(Model model) {
        List<Schedule> schedules = scheduleServiceImpl.findAllScheduleByMovie();
        model.addAttribute("scheduleList", schedules);
        return "schedulePage";
    }

    @GetMapping("/detail/{id}")
    public String detailSchedule(@PathVariable("id") Long id, Model model) {
        Schedule schedule = scheduleServiceImpl.findSchedulesByMovieTitle(id);
        if (schedule == null) {
            return "error";
        }
        model.addAttribute("schedule", schedule);
        return "movieDetail";
    }
}
