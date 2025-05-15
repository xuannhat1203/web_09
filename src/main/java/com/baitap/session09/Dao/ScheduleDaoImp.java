package com.baitap.session09.Dao;

import com.baitap.session09.modal.Schedule;
import com.baitap.session09.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDaoImp implements ScheduleDao {
    @Override
    public List<Schedule> findAllScheduleByMovie() {
        List<Schedule> schedules = new ArrayList<>();
        try (Connection con = ConnectionDB.openConnection();
             CallableStatement cstmt = con.prepareCall("{call find_all_schedulebyMovie()}");
             ResultSet rs = cstmt.executeQuery()) {

            while (rs.next()) {
                Schedule s = new Schedule();
                s.setId(rs.getLong("id"));
                s.setMovieTitle(rs.getString("movietitle"));
                s.setShowTime(rs.getTimestamp("showtime"));
                s.setScreenRoomName(rs.getString("screenroomname"));
                s.setAvailableSeats(rs.getInt("availableseats"));
                s.setFormat(rs.getString("format"));
                schedules.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return schedules;
    }

    @Override
    public Schedule findSchedulesByMovieTitle(long id) {
        Schedule schedule = null;
        Connection con = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        List<Schedule> schedules = new ArrayList<>();
        try {
            con = ConnectionDB.openConnection();
            cstmt = con.prepareCall("{call find_schedule_by_id(?)}");
            cstmt.setLong(1, id);
            rs = cstmt.executeQuery();
            if (rs.next()) {
                schedule = new Schedule();
                schedule.setId(rs.getLong("id"));
                schedule.setMovieTitle(rs.getString("movietitle"));
                schedule.setShowTime(rs.getTimestamp("showtime"));
                schedule.setAvailableSeats(rs.getInt("availableseats"));
                schedule.setFormat(rs.getString("format"));
                schedule.setScreenRoomName(rs.getString("screenroomname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (cstmt != null) cstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return schedule;
    }
}
