package com.baitap.session09.Service;

import com.baitap.session09.Dao.ScheduleDao;
import com.baitap.session09.Dao.ScheduleDaoImp;
import com.baitap.session09.modal.Schedule;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SchedualServiceImp implements ScheduleService {
    public ScheduleDao scheduleDao;
    public SchedualServiceImp() {
        scheduleDao = new ScheduleDaoImp();
    }
    @Override
    public List<Schedule> findAllScheduleByMovie() {
        return scheduleDao.findAllScheduleByMovie();
    }
    @Override
    public Schedule findSchedulesByMovieTitle(long id) {
        return scheduleDao.findSchedulesByMovieTitle(id);
    }
}
