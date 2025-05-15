package com.baitap.session09.Service;

import com.baitap.session09.modal.Schedule;

import java.util.List;

public interface ScheduleService {
    List<Schedule> findAllScheduleByMovie();
    Schedule findSchedulesByMovieTitle(long id);
}
