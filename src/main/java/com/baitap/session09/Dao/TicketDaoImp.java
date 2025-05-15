
package com.baitap.session09.Dao;

import com.baitap.session09.modal.Ticket;
import com.baitap.session09.modal.Seat;
import com.baitap.session09.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TicketDaoImp implements TicketDao {

    @Override
    public boolean addTicket(Ticket ticket) {
        Connection con = null;
        CallableStatement cstmt = null;
        boolean success = false;
        try {
            con = ConnectionDB.openConnection();
            cstmt = con.prepareCall("{call add_ticket(?, ?, ?)}");
            cstmt.setLong(1, ticket.getCustomerId());
            cstmt.setLong(2, ticket.getScheduleId());
            cstmt.setDouble(3, ticket.getTotalMoney());
            cstmt.executeUpdate();
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
    @Override
    public Long getLastTicketId() {
        Connection con = null;
        CallableStatement cstmt = null;
        Long ticketId = null;
        try {
            con = ConnectionDB.openConnection();
            cstmt = con.prepareCall("{call get_last_ticket_id()}");
            ResultSet rs = cstmt.executeQuery();
            if (rs.next()) {
                ticketId = rs.getLong("ticket_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticketId;
    }
    @Override
    public boolean addTicketSeat(Long ticketId, Long seatId) {
        Connection con = null;
        CallableStatement cstmt = null;
        boolean success = false;
        try {
            con = ConnectionDB.openConnection();
            cstmt = con.prepareCall("{call add_ticket_seat(?, ?)}");
            cstmt.setLong(1, ticketId);
            cstmt.setLong(2, seatId);
            cstmt.executeUpdate();
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
    @Override
    public boolean updateSeatStatus(Long seatId, String status) {
        Connection con = null;
        CallableStatement cstmt = null;
        boolean success = false;
        try {
            con = ConnectionDB.openConnection();
            cstmt = con.prepareCall("{call update_seat_status(?, ?)}");
            cstmt.setLong(1, seatId);
            cstmt.setString(2, status);
            cstmt.executeUpdate();
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
    @Override
    public boolean updateAvailableSeats(Long scheduleId, int seatCount) {
        Connection con = null;
        CallableStatement cstmt = null;
        boolean success = false;
        try {
            con = ConnectionDB.openConnection();
            cstmt = con.prepareCall("{call update_available_seats(?, ?)}");
            cstmt.setLong(1, scheduleId);
            cstmt.setInt(2, seatCount);
            cstmt.executeUpdate();
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}
