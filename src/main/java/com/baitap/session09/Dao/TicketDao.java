package com.baitap.session09.Dao;
import com.baitap.session09.modal.Ticket;
public interface TicketDao {
    boolean addTicket(Ticket ticket);
    public Long getLastTicketId();
    public boolean addTicketSeat(Long ticketId, Long seatId);
    public boolean updateSeatStatus(Long seatId, String status);
    public boolean updateAvailableSeats(Long scheduleId, int seatCount);
}

