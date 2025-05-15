package com.baitap.session09.Dao;

import com.baitap.session09.modal.Schedule;

import java.util.List;

public interface ScheduleDao {
    List<Schedule> findAllScheduleByMovie();
    Schedule findSchedulesByMovieTitle(long id);
}
